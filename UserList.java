import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    //Create list of users
    public UserList() 
    {
        users= DataLoader.getUsers();
    }

    //Get instance of a user list
    public static UserList getInstance() 
    {
        if(userList == null){
            userList = new UserList();
        }
        return userList;
    }

    //Get a user from the list by their email and password
    public User getUser(String userEmail, String userPassword) {
        
        for(int i=0;i<users.size();i++)
        {
            //User user = users.get(i);
            if(users.get(i).getEmailID().equalsIgnoreCase(userEmail) && users.get(i).getPassword().equalsIgnoreCase(userPassword))
            {
                return users.get(i);
            }
        }
        return null;
    }

    public boolean addUser(String emailID) //only checking if we can add user based on emailID!!
    {
        //loop through userlist-check for unqiue email
        //true if email is not found
        users = DataLoader.getUsers();
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).userEmail.equalsIgnoreCase(emailID))
            {
                return false;
            }
        }
        return true;
    }

    //Add a user to the list
    public boolean add(String firstName, String lastName, String userEmail, String userPassword)
    {
        User user = new User(firstName, lastName, userEmail, userPassword);
        users.add(user);
        return true;
    }
    public void saveUsers()
    {
        DataWriter.saveUsers();
    }

    //Get all users from the list
    public ArrayList<User> getUsers()
    {
        return users;
    }
    
    //Get a user by their uuid
    public User getUser(UUID id)
    {
        for(int i=0; i<users.size(); i++)
        {
            if(users.get(i).getId().equals(id))
                return users.get(i);
        }
        return null;
    }

}
