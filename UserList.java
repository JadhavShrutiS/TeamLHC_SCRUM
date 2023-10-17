import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;
    private UserList userList;

    private UserList() {
        DataLoader.getUsers();
    }

    public UserList getInstance() {
        //users = new ArrayList<>(users);
        return userList;
    }

    public User getUser(String userName) {
        
        return users.get(0);
    }

    public boolean addUser(String firstName, String lastName, String emailID, String password) {
        if (firstName != null && lastName != null && emailID != null && password != null)
            return users.add(null);
        else
            return false;
    }
}
