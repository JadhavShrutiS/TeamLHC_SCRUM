import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
				
				JSONArray users = (JSONArray)projectJSON.get(PROJECT_USERS);
				for(int j=0; j < users.size(); j++)
				{

					JSONObject user = (JSONObject)users.get(i);

					String role = (String)user.get(PROJECT_USER_ROLE);
					UUID userID = UUID.fromString((String)user.get(PROJECT_USER_ID));
					

				}
				

				//ArrayList<User> users = (ArrayList)projectJSON.get(PROJECT_USERS);
				
				String projectName = (String)projectJSON.get(PROJECT_NAME);
				String projectDescription = (String)projectJSON.get(PROJECT_DESCRIPTION);
				//columns??
				//Comments??

				projects.add(new Project(projectID, projectName, projectDescription));			
			}
			
			return projects;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
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
				//UUID userID = UUID.fromString((String)TaskJSON.get(TASK_USER_ID));
				String taskName = (String)TaskJSON.get(TASK_NAME);
				String taskDescription = (String)TaskJSON.get(TASK_DESCRIPTION);
				String taskPriority = (String)TaskJSON.get(TASK_ID);
				//need to do comments and subtasks
				Tasks.add(new Task(taskID, taskName, taskDescription, taskPriority));			
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
