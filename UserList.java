import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;
    private UserList userList;

    private UserList() {
        this.users = users;
        this.userList = userList;
    }

    public UserList getInstance() {
        return userList;
    }

    public User getUser(String userName) {
        return null;
    }

    public boolean addUser(String firstName, String lastName, String emailID, String password) {
        return true;
    }
}
