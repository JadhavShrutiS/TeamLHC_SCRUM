import java.util.ArrayList;
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

    public void addColumn(Column column) {
        columns.add(column);
    }

    //Remove a column
    public void deleteColumn(Column column) {
        columns.remove(column);
    }

    public void addTask(Task task)
    {
        for(int i=0;i<columns.size();i++)
        {
            if(columns.get(i).name.equalsIgnoreCase("todo"))
            {
                columns.get(i).addtask(task);
            }
        }
    }

    public void moveTask(Task task, Column column)
    {
        for(int i=0;i<columns.size();i++)
        {
            for(int j=0;j<columns.get(i).getTasks().size();j++)
            {
                if(columns.get(i).getTasks().get(j).taskName.equalsIgnoreCase(task.taskName))
                {
                    
                }
            }
        }
    }



    //Adds a comment to an array list of comments
    public void addComment(Comment comment) 
    {
        comments.add(comment);
    }

    //Adds a user to an array list of users
    public void addUsers(User user) 
    {
       users.add(user);
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

    public ArrayList<User> getUsers() {
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

    public User getScrumMaster() {
        return scrumMaster;
    }

    public User getProductOwner() {
        return productOwner;
    }

    public String toString()
    {
        return "\n\nPROJECT\nNAME: "+this.projectName+"\nDESCRIPTION: "+this.projectDescription+"\nSCRUMMASTER: "+this.scrumMaster+"\nPRODUCTOWNER: "+this.productOwner+"\nUSERS: "+this.users+"\nCOLUMNS:\n"+this.columns+"\nPROJECT-COMMENTS"+this.comments;
    }
    public void setScrumMaster(User user)
    {
        this.scrumMaster = user;
    }
    public void setProductOwner(User user)
    {
        this.productOwner = user;
    }


}