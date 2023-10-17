import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{

    public static void saveUsers()
    {
        /* 
        UserList users = UserList.getInstance();
		ArrayList<User> userList = users.getUsers();
        */
        ArrayList<User> userList = new ArrayList<>();
        User john = new User();
        userList.add(john);

		JSONArray jsonUsers = new JSONArray();
		
        for(int i=0; i< userList.size(); i++) {
			jsonUsers.add(getUserJSON(userList.get(i)));
		}
		
        try (FileWriter file = new FileWriter("json/users1.json")) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put("userID", "43636345345");//user.getId().toString());
		userDetails.put("firstName", "John");//user.getFirstName());
		userDetails.put("lastName", "Smith");//user.getLastName());
		userDetails.put("emailID", "John@email");//user.getEmailID());
		userDetails.put("password", "1234");//user.getPassword());
        
        return userDetails;
	}

    public static boolean saveProjects()
    {
        return true;
    }

    public static void main(String[] args) {
        saveUsers();
    }
    
}
