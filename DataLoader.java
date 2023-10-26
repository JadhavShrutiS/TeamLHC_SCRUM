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
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			
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
			JSONArray projectJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < projectJSON.size(); i++) 
			{
				
				
				projects.add(new Project(id, firstName, lastName, userEmail, userPassword));			
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
	}

	public static void main(String[] args)
	{
	
		System.out.println(getUsers().toString());
		
	
	}
}
