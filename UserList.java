import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    private UserList() {
        DataLoader.getUsers();
    }

    public UserList getInstance() {
        return userList;
    }

    public User getUser(String userName) {
        
        return users.get(0);
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

    public void add(User newUser)
    {
        users.add(newUser);
    }

    public String toString(){
        return " asd";
    }
}
