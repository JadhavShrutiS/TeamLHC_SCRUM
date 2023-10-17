import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    private UserList() {
        this.users = users;
        this.userList = userList;
    }

    public static UserList getInstance() {
        return userList;
    }

    public User getUser(String userName) {
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean addUser(String firstName, String lastName, String emailID, String password) 
    {   boolean x = true;
        int y = 0;
        //loop through userList- check for unique email
        //true if email is not found
        users = DataLoader.getUsers();
        while(x && y != users.size()){
            y++;
        }

        return true;
    }
}
