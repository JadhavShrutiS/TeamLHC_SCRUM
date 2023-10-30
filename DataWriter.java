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
		
        for (int i=0; i<taskList.size(); i++) {
            jsonTasks.add(getTaskJSON(taskList.get(i)));
        }
        /*
         * 
        
        for(int i=0; i< taskList.size(); i++) {
            if (taskList.get(i) instanceof Bug) {
                jsonTasks.add(getBugJSON(((Bug)taskList.get(i))));
            } else {
                jsonTasks.add(getFeatureJSON(((Feature)taskList.get(i))));
            }
			
		} */
		
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
        
        if(task.getUsers()!=null)
        {
            JSONArray userids = new JSONArray();
            for(int i=0;i<task.getUsers().size();i++)
            {
                //taskDetails.put(TASK_USER_ID, task.getUserIDs().get(i).toString());
                userids.add(i, task.getUsers().get(i).getId().toString());
            }
            taskDetails.put("userids", userids);
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

        if(task.getSubtasks()!=null)
        {
            JSONArray subtasks = new JSONArray();
            for(int i=0;i<task.subTasks.size();i++)
            {
                subtasks.add(i, task.getSubtasks().get(i));
            }
            taskDetails.put("subtasks", subtasks);
        }
        else
        {
            taskDetails.put(TASK_SUBTASKS,null);
        }

        if (task instanceof Bug) {
            taskDetails.put("title", ((Bug)task).getBug());
            taskDetails.put("tester", ((Bug)task).getTester().toString());
        } else {
            taskDetails.put("title", ((Feature)task).getFeature());
            taskDetails.put("tester", null);
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
 
    public static JSONObject getProjectJSON(Project project) 
    {
		JSONObject projectDetails = new JSONObject();
		projectDetails.put("projectID", project.getProjectID());
        
        JSONArray userids = new JSONArray();
        for (int i=0; i<project.getUsers().size(); i++) {
            userids.add(i, project.getUsers().get(i));
        }
        projectDetails.put("userids", userids);
        projectDetails.put("scrummaster", project.getScrumMaster().getId().toString());
        projectDetails.put("productowner", project.getProductOwner().getId().toString());
        projectDetails.put("description", project.getProjectDescription());

        JSONArray columns = new JSONArray();
        for (int i=0; i<project.getColumns().size(); i++) {
            JSONObject column = new JSONObject();
            column.put("name", project.getColumns().get(i).getName());
            JSONArray tasks = new JSONArray();
            for (int j=0; j<project.getColumns().get(i).getTasks().size(); j++) {
                JSONObject task = new JSONObject();
                task.put("tasks", project.getColumns().get(i).getTasks().get(j));
                tasks.add(j, task);
            }
            column.put("name", project.getColumns().get(i).getName());
            column.put("tasks", tasks);
            columns.add(column);
        }
		projectDetails.put("columns", columns);

        JSONArray comments = new JSONArray();
        for (int i=0; i<project.getComments().size(); i++) {
            JSONObject comment = new JSONObject();
            comment.put("userid", project.getComments().get(i).getUserID().toString());
            comment.put("date", project.getComments().get(i).getDate().toString());
            comment.put("comment", project.getComments().get(i).getComment());
            comments.add(comment);
        }
		projectDetails.put("comments", comments);


        return projectDetails;
        }
    

        public static void main(String[] args) {
        System.out.println("hi");
        //saveProjects();
    }
}
