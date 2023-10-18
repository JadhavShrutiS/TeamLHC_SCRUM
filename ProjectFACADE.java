 import java.util.ArrayList;

public class ProjectFACADE {
    private User user;
    private ProjectBoard projectBoard;
    private UserList userList;

    public User login(String emailID, String password) {
        user = UserList.getInstance().getUser(emailID,password);
        return user;
    }

    public Boolean signUp(String firstName, String LastName, String emailID, String password) 
    {
         return UserList.getInstance().addUser(firstName, LastName, emailID,password);
    }

    public Project getProjectByName(String name) {
        return projectBoard.getProject(name);

    }

    public ArrayList<Project> getAllProjects() {
        return projectBoard.getAllProjects();
    }

    public boolean createProject(String name) {
        return true;
    }
    public boolean createColumn(String name) {
        return true;
    }
    public boolean createTask(Project project, Column column) {
        return true;

    }

    public void addCommentProject(Project project) {

    }

    public void addCommentTask(Task task) {

    }

    public boolean createReport(Project project) {
        return true;

    }
    public void logout() {
        userList.getInstance().saveUsers();
    }
}
