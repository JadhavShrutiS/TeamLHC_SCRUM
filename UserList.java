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

    public boolean addUser(String firstName, String lastName, String emailID, String password) {
        return true;
    }
}
