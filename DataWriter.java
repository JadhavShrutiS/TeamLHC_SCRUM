import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants
{

    public static void saveUsers()
    {
        
        UserList users = UserList.getInstance();
		ArrayList<User> userList = users.getUsers();
        //ArrayList<User> userList = new ArrayList<>();
        /* 
        User john = new User();
        userList.add(john);
        */

		JSONArray jsonUsers = new JSONArray();
		
        for(int i=0; i< userList.size(); i++) {
			jsonUsers.add(getUserJSON(userList.get(i)));
		}
		
        try (FileWriter file = new FileWriter("json/users.json")) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveTasks()
    {
        TaskList tasks = TaskList.getInstance();
		ArrayList<Task> taskList = tasks.getTasks();
        //ArrayList<User> userList = new ArrayList<>();
        /* 
        User john = new User();
        userList.add(john);
        */

		JSONArray jsonTasks = new JSONArray();
		
        for(int i=0; i< taskList.size(); i++) {
			jsonTasks.add(getTaskJSON(taskList.get(i)));
		}
		
        try (FileWriter file = new FileWriter("json/tasks1.json")) {
 
            file.write(jsonTasks.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static JSONObject getTaskJSON(Task task)
    {
        JSONObject taskDetails = new JSONObject();
        taskDetails.put(TASK_ID,task.getTaskId().toString());
		taskDetails.put(TASK_NAME,task.getTaskName());
		taskDetails.put(TASK_DESCRIPTION, task.getTaskDescription());
		taskDetails.put(TASK_PRIORITY, Integer.toString(task.getTaskPriority()));
        //write users
        //JSONObject users = new JSONObject();
        



        if(task.getUserIDs()!=null)
        {
            for(int i=0;i<task.getUserIDs().size();i++)
            {
                taskDetails.put(TASK_USER_ID, task.getUserIDs().get(i).toString());

            }
        }
        else
        {
            taskDetails.put(TASK_USER_ID, "none");
        }
        
        //write comments- works!!!!
        JSONArray taskComments = new JSONArray();
        if(task.getTaskComments()!=null)
        {
            for(int i =0;i<task.getTaskComments().size();i++)
            {
                JSONObject comment = new JSONObject();
                comment.put(TASK_COMMENT_USER_ID,task.getTaskComments().get(i).getUserID().toString());
                comment.put(TASK_COMMENT_DATE,task.getTaskComments().get(i).getDate().toString());
                comment.put(TASK_COMMENT_STRING,task.getTaskComments().get(i).getComment());
                taskComments.add(comment);
                taskDetails.put(TASK_COMMENT, taskComments);
            }

        }
        else
        {
            JSONObject comment = new JSONObject();
            comment.put(TASK_COMMENT_USER_ID,"");
            comment.put(TASK_COMMENT_DATE,"");
            comment.put(TASK_COMMENT_STRING,"");
            taskComments.add(comment);
            taskDetails.put(TASK_COMMENT, taskComments);
        }
        //write subtasks
        //JSONObject subtasks = new JSONObject();

        if(task.getSubtasks()!=null)
        {
            for(int i=0;i<task.subTasks.size();i++)
            {
                taskDetails.put(TASK_SUBTASKS, task.getSubtasks().get(i));

            }
        }
        else
        {
            taskDetails.put(TASK_SUBTASKS,null);
        }
        
        return taskDetails;
    }


    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID,user.getId().toString());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_EMAIL, user.getEmailID());
		userDetails.put(USER_PASSWORD, user.getPassword());
        
        return userDetails;
	}

    public static void saveProjects()
    {
        ArrayList<Project> projects = ProjectBoard.getInstance().getAllProjects();
		JSONArray jsonProjects = new JSONArray();
		
        for(int i=0; i < projects.size(); i++) {
			jsonProjects.add(getProjectJSON(projects.get(i)));
		}
		
        try (FileWriter file = new FileWriter("json/projects1.json")) {
 
            file.write(jsonProjects.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/* 
    public static JSONObject getProjectJSON(Project project) 
    {
		JSONObject projectDetails = new JSONObject();
		projectDetails.put("projectID", project.getUUID());
        JSONArray users = new JSONArray();
        JSONObject supervisor = new JSONObject();
        supervisor.put("role", "scrum master");
        supervisor.put("id", project.getSupervisor().getId());
        JSONObject productOwner = new JSONObject();
        productOwner.put("role", "product owner");
        productOwner.put("id", project.getProductOwner().getId());
        users.add(supervisor);
        users.add(productOwner);
        for (int i = 0; i < project.getUsers().size(); i++) {
            JSONObject user = new JSONObject();
            user.put("role", "developer");
            user.put("id", project.getUsers().get(i).getId());
            users.add(user);
        }
		projectDetails.put("user", users);
        projectDetails.put("description", project.getDescription());

        JSONArray columns = new JSONArray();
        for (int i=0; i<project.getColumns().size(); i++) {
            JSONObject column = new JSONObject();
            column.put("name", project.getColumns().get(i).getName());
            column.put("tasks", project.getColumns().get(i).getTaskList());
            columns.add(column);
        }
		projectDetails.put("columns", columns);

        JSONArray comments = new JSONArray();
        for (int i=0; i<project.getComments().size(); i++) {
            JSONObject comment = new JSONObject();
            comment.put("userid", project.getComments().get(i).getUserId());
            comment.put("date", project.getComments().get(i),getDate());
            comment.put("comment", project.getComments().get(i).getComment());
            comments.add(comment);
        }
		projectDetails.put("comments", comments);


        return projectDetails;
        }
    }
*/
        public static void main(String[] args) {
        System.out.println("hi");
        //saveProjects();
    }
}
