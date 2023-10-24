import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Yug Desai
 */
public class Project {
    private String name;
    private UUID uuid;
    private String description;
    private ArrayList<Column> columns;
    private ArrayList<Comment> comments;
    private ArrayList<User> users;
    private ArrayList<Role> roles;
    private User supervisor;

    public Project(String name, String description, UUID uuid, ArrayList<User> users, ArrayList<Role> roles, User supervisor) {
        this.name = name;
        this.uuid = uuid;
        this.description = description;
        this.users = users;
        this.roles = roles;
        this.supervisor = supervisor;
        this.columns = new ArrayList<Column>();
        this.comments = new ArrayList<Comment>();
    }

    public void deleteColumn(Column column) {
        columns.remove(column);
    }

    public boolean completedTask(Task task) {
        return true;

    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addUser (User user) {
        users.add(user);
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

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public ArrayList<Role> getRoles() {
        return this.roles;
    }

    public ArrayList<Column> getColumns() {
        return this.columns;
    }

    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    public User getSupervisor() {
        return this.supervisor;
    }

}