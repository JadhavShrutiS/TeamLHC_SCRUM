import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Yug Desai
 */
public class Project {
    private String projName;
    private UUID uuid;
    private String projDescription;
    private ArrayList<Column> columns;
    private ArrayList<Comment> comments;
    //private ArrayList<User> users;
    private HashMap<Role, User> users;
    private Role scrumMaster;
    private Role developer;
    private Role productOwner;

    
    public Project()
    {
        this.projName= "Project1";
        this.uuid =UUID.randomUUID();
        this.projDescription = "Project Description";
        this.columns = new ArrayList<Column>();
        this.comments =  new ArrayList<Comment>();
        this.users = new HashMap<Role, User>();
        users.put(developer, null);

    }
    
    public Project(String name, String description, UUID uuid, ArrayList<User> users) {
        this.projName = name;
        this.uuid = uuid;
        this.projDescription = description;
        //this.users = users;
        this.columns = new ArrayList<Column>();
        this.comments = new ArrayList<Comment>();
    }

    //testing
    public Project(UUID projectID, String projectName, String projectDescription)
    {
        this.uuid = projectID;
        this.projName = projectName;
        this.projDescription = projectDescription;
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

    public String getName() {
        return this.name;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public String getDescription() {
        return this.description;
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