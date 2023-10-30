 import java.util.ArrayList;

public class ProjectFACADE {
    private User user;
    private ProjectBoard projectBoard;
    private UserList userList;
    private TaskList taskList;
    private Task task;

    public User login(String emailID, String password) {
        user = UserList.getInstance().getUser(emailID,password);
        return user;
    }

    public Boolean signUp(String firstName, String LastName, String emailID, String password) 
    {
        return UserList.getInstance().add(firstName, LastName, emailID,password);

    }

    public Boolean addTask(String taskName, String taskDesc, int priority)
    {
        return TaskList.getInstance().addTask(taskName);
        //return TaskList.getInstance().add(taskName, taskDesc, priority);
    }

    public Task getTask(String taskName)
    {
        task = TaskList.getInstance().getTask(taskName);
        return task;
    }

    public ArrayList<Task> getTasks()
    {
        return TaskList.getInstance().getTasks();
    }

    public User getUser(){
        return user;
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

    public boolean createReport(Project project) {
        return true;

    }
    public void logout() {
        UserList.getInstance().saveUsers();
        TaskList.getInstance().saveTasks();
        DataWriter.saveProjects();
    }
}
