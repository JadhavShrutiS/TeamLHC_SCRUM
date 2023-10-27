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
    private ArrayList<User> users;
    private User scrumMaster;
    private User productOwner;

    
    public Project()
    {
        this.projectName= "Project1";
        this.projectID =UUID.randomUUID();
        this.projectDescription = "Project Description";
        this.columns = new ArrayList<Column>();
        this.comments =  new ArrayList<Comment>();

    }
    
    //existing projects
    public Project(UUID projectID, String projectName, String projectDescription, ArrayList<Column> columns, ArrayList<Comment> comment, ArrayList<User> users, User scrumMaster, User productOwner) {
        this.projectName = projectName;
        this.projectID = projectID;
        this.projectDescription = projectDescription;
        this.users = users;
        this.columns = columns;
        this.scrumMaster = scrumMaster;
        this.productOwner = productOwner;
        this.comments = comment;
    }

    //new projects
    public Project(String projectName, String projectDescription)
    {
        this.projectID = UUID.randomUUID();
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.users = null;
        this.columns=null;
        this.comments=null;
        this.scrumMaster = null;
        this.productOwner = null;

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