import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.sql.Date;
/**
 * @author Sri
 * @author Shruti
 */

public class DataLoader extends DataConstants{
	
	public static ArrayList<User> getUsers(){
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)parser.parse(reader);
			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				
				String lastName = (String)personJSON.get(USER_LAST_NAME);
				String userEmail = (String)personJSON.get(USER_EMAIL);
				String userPassword = (String)personJSON.get(USER_PASSWORD);
				
				String firstName = (String)personJSON.get(USER_FIRST_NAME);
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
				
				users.add(new User(id, firstName, lastName, userEmail, userPassword));			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//get user by uuid	
	public static User getUser(UUID uuid)
	{
		try 
		{
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)parser.parse(reader);
			for(int i=0; i < peopleJSON.size(); i++) 
			{
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
				if(id.equals(uuid))
				{
					String lastName = (String)personJSON.get(USER_LAST_NAME);
					String userEmail = (String)personJSON.get(USER_EMAIL);
					String userPassword = (String)personJSON.get(USER_PASSWORD);
					String firstName = (String)personJSON.get(USER_FIRST_NAME);
					User user = new User(id, firstName, lastName, userEmail, userPassword);
					return user;
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}


    public static ArrayList<Project> getProjects()
	{
		ArrayList<Project> projects = new ArrayList<Project>();

		try {
			FileReader reader = new FileReader(PROJECT_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray projectsJSON = (JSONArray)parser.parse(reader);
			
			for(int i=0; i < projectsJSON.size(); i++) 
			{
				JSONObject projectJSON = (JSONObject)projectsJSON.get(i);
				
				UUID projectID = UUID.fromString((String)projectJSON.get(PROJECT_ID));

				String projectName = (String)projectJSON.get(PROJECT_NAME);
				String projectDescription = (String)projectJSON.get(PROJECT_DESCRIPTION);
				
				ArrayList<User> Users = new ArrayList<User>();
				JSONArray user = (JSONArray)projectJSON.get(TASK_USER_ID);
				for(int j=0;j<user.size();j++)
				{
					UUID userID = UUID.fromString((String)user.get(j));

					Users.add(getUser(userID));
				}

				User scrumMaster = getUser(UUID.fromString((String)projectJSON.get(PROJECT_USER_SCRUMMASTER)));
				User productOwnder = getUser(UUID.fromString((String)projectJSON.get(PROJECT_USER_PRODUCTOWNER)));

				//Comments
				ArrayList<Comment> projectComments = new ArrayList<Comment>();
				JSONArray comments = (JSONArray)projectJSON.get(PROEJCT_COMMENT);
				for(int j =0;j<comments.size();j++)
				{
					JSONObject commentJSON = (JSONObject)comments.get(j);

					UUID commentUserID = UUID.fromString((String)commentJSON.get(PROJECT_COMMENT_USER_ID));
					Date date = Date.valueOf((String)commentJSON.get(PROJECT_COMMENT_DATE));
					String commentString = (String)commentJSON.get(PROJECT_COMMENT_DATE);

					projectComments.add(new Comment(commentUserID, date, commentString));
				}
				//Column
				ArrayList<Column> projectColumns = new ArrayList<Column>();
				JSONArray columns = (JSONArray)projectJSON.get(PROJECT_COLUMNS);
				for(int j =0;j<columns.size();j++)
				{
					JSONObject columnJSON = (JSONObject)comments.get(j);
					String columnName = (String)columnJSON.get(PROJECT_COLUMN_NAME);

					ArrayList<Task> columnTasks = new ArrayList<Task>();
					JSONArray columnTask = (JSONArray)projectJSON.get(PROJECT_COLUMN_TASKS);
					for(int k=0;k<columnTask.size();k++)
					{
						UUID taskuuid = UUID.fromString((String)columnTask.get(k));
						//convert task uuid to task
						columnTasks.add(getTask(taskuuid));
					}
					Column column = new Column(columnName,columnTasks);
					projectColumns.add(column);
				}
				
				projects.add(new Project(projectID, projectName, projectDescription, projectColumns, projectComments, Users, scrumMaster, productOwner));			
			}
			
			return projects;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
/****************************************************************** */
	public static Task getTask(UUID uuid)
	{
		try {
			FileReader reader = new FileReader(TASK_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray TasksJSON = (JSONArray)parser.parse(reader);
			
			for(int i=0; i < TasksJSON.size(); i++) 
			{
				JSONObject TaskJSON = (JSONObject)TasksJSON.get(i);

				UUID taskID = UUID.fromString((String)TaskJSON.get(TASK_ID));
				if(taskID.equals(uuid))
				{

					//UUID userID = UUID.fromString((String)TaskJSON.get(TASK_USER_ID));//there can be multiple users

					//multiple user ids in a list
					ArrayList<User> Users = new ArrayList<User>();
					JSONArray user = (JSONArray)TaskJSON.get(TASK_USER_ID);
					for(int j=0;j<user.size();j++)
					{
						UUID userID = UUID.fromString((String)user.get(j));

						Users.add(getUser(userID));
					}

					String taskName = (String)TaskJSON.get(TASK_NAME);
					String taskDescription = (String)TaskJSON.get(TASK_DESCRIPTION);
					int taskPriority = Integer.parseInt((String)TaskJSON.get(TASK_PRIORITY));

					//comments
					ArrayList<Comment> taskComments = new ArrayList<Comment>();
					JSONArray comments = (JSONArray)TaskJSON.get(TASK_COMMENT);
					for(int j =0;j<comments.size();j++)
					{
						JSONObject commentJSON = (JSONObject)comments.get(j);

						UUID commentUserID = UUID.fromString((String)commentJSON.get(TASK_COMMENT_USER_ID));
						Date date = Date.valueOf((String)commentJSON.get(TASK_COMMENT_DATE));
						String commentString = (String)commentJSON.get(TASK_COMMENT_STRING);

						taskComments.add(new Comment(commentUserID, date, commentString));
					}

					//subtasks
					ArrayList<String> subtasks = new ArrayList<String>();
					JSONArray subtask = (JSONArray)TaskJSON.get(TASK_SUBTASKS);
					for(int j=0;j<subtask.size();j++)
					{
						subtasks.add((String)subtask.get(j));
					}

					Task task = new Task(taskID,Users,taskName,taskDescription,taskPriority,taskComments,subtasks);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

 /************************************************************* */
	public static ArrayList<Task> getTasks()
	{
		//test this out...first
		ArrayList<Task> Tasks = new ArrayList<Task>();
		
		try {
			FileReader reader = new FileReader(TASK_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray TasksJSON = (JSONArray)parser.parse(reader);
			
			for(int i=0; i < TasksJSON.size(); i++) {
				JSONObject TaskJSON = (JSONObject)TasksJSON.get(i);
				
				UUID taskID = UUID.fromString((String)TaskJSON.get(TASK_ID));
				
				//multiple users in a list
				ArrayList<User> Users = new ArrayList<User>();
				JSONArray user = (JSONArray)TaskJSON.get(TASK_USER_ID);
				for(int j=0;j<user.size();j++)
				{
					UUID userID = UUID.fromString((String)user.get(j));

					Users.add(getUser(userID));
				}

				String taskName = (String)TaskJSON.get(TASK_NAME);
				String taskDescription = (String)TaskJSON.get(TASK_DESCRIPTION);
				int taskPriority = Integer.parseInt((String)TaskJSON.get(TASK_PRIORITY));

				//comments
				ArrayList<Comment> taskComments = new ArrayList<Comment>();
				JSONArray comments = (JSONArray)TaskJSON.get(TASK_COMMENT);
				for(int j =0;j<comments.size();j++)
				{
					JSONObject commentJSON = (JSONObject)comments.get(j);

					UUID commentUserID = UUID.fromString((String)commentJSON.get(TASK_COMMENT_USER_ID));
					Date date = Date.valueOf((String)commentJSON.get(TASK_COMMENT_DATE));
					String commentString = (String)commentJSON.get(TASK_COMMENT_STRING);

					taskComments.add(new Comment(commentUserID, date, commentString));
				}

				//subtasks
				ArrayList<String> subtasks = new ArrayList<String>();
				JSONArray subtask = (JSONArray)TaskJSON.get(TASK_SUBTASKS);
				for(int j=0;j<subtask.size();j++)
				{
					subtasks.add((String)subtask.get(j));
				}

				Tasks.add(new Task(taskID,userIDs,taskName,taskDescription,taskPriority,taskComments,subtasks));
		
			}
			
			return Tasks;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static void main(String[] args)
	{
	
		System.out.println(getUsers().toString());
		System.out.println(getTasks().toString());
		
	
	}
}
