import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Yug Desai
 */
public class Project {
    private String projectName;
    private UUID projectID;
    private String projectDescription;
    private ArrayList<Column> columns;
    private ArrayList<Comment> comments;
    //private ArrayList<User> users;
    private HashMap<Role, User> users;
    private Role scrumMaster;
    private Role developer;
    private Role productOwner;

    
    public Project()
    {
        this.projectName= "Project1";
        this.projectID =UUID.randomUUID();
        this.projectDescription = "Project Description";
        this.columns = new ArrayList<Column>();
        this.comments =  new ArrayList<Comment>();
        this.users = new HashMap<Role, User>();
        users.put(developer, null);

    }
    
    public Project(String name, String description, UUID uuid, ArrayList<User> users) {
        this.projectName = name;
        this.projectID = uuid;
        this.projectDescription = description;
        //this.users = users;
        this.columns = new ArrayList<Column>();
        this.comments = new ArrayList<Comment>();
    }

    //testing
    public Project(UUID projectID, String projectName, String projectDescription)
    {
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    public void deleteColumn(Column column) {
        columns.remove(column);
    }

    public boolean completedTask(Task task) {
        return true;

    }

    public void addComment(Comment comment) 
    {
        comments.add(comment);
    }

    public void addUsers(Role role, User user) 
    {
       users.put(role, user);
    }

    public void createReport() {
        
    }

    public String getProjectName() {
        return this.projectName;
    }

    public UUID getProjectID() {
        return this.projectID;
    }

    public String getProjectDescription() {
        return this.projectDescription;
    }

    public HashMap<Role,User> getUsers() {
        return this.users;
    }

    public ArrayList<Column> getColumns() {
        return this.columns;
    }

    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    public Task getTask()
    {
        //cycle through all tasks in project and return task
        return null;
    }


}