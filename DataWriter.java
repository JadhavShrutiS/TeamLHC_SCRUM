import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{

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
		
        for(int i=0; i< projects.size(); i++) {
			jsonProjects.add(getProjectJSON(projects.get(i)));
		}
		
        try (FileWriter file = new FileWriter("json/projects1.json")) {
 
            file.write(jsonProjects.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getProjectJSON(Project project) {
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
		//projectDetails.put("columns", );
		//projectDetails.put("comments", );
        }
    }

    public static void main(String[] args) {
        System.out.println("hi");
        saveProjects();

    }
    
}
