import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
	
	public static ArrayList<User> getUsers(){
		return new ArrayList<User>();
	}

    public static ArrayList<Project> getProjects(){
		return new ArrayList<Project>();
	}

}
