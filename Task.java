import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Sri Nandury
 */

public class Task {

    public UUID taskUUID;
    public User user;
    public String taskName;
    public String taskDescription;
    public int taskPriority;
    public ArrayList<Comment> taskComments;
    public ArrayList<String> links;
    public Date date;
    public ArrayList<String> subTasks;
    public UUID userUUID;

    Task(String taskName){
        this.taskUUID = UUID.randomUUID();
        this.user = user;
        this.taskName = taskName;
    }

    Task(User user, String taskName, String taskDescription){
        this.taskUUID = UUID.randomUUID();
        this.user = user; 
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public Task(String taskName, String taskDescription, int taskPriority){
        this.taskUUID = UUID.randomUUID(); 
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;
    }

    //create task- testing
    public Task(UUID taskID, String taskName, String taskDescription, int taskPriority)
    {
        this.taskUUID = taskID; 
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;
    }

    public  void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;
    }

    public void setPriorityColor(int taskPriority){
        this.taskPriority = taskPriority;
    }

    public void addComment(Comment comment){
        taskComments.add(taskComments.size(), comment);
    }

    public void addSubTask(String subTask){
        subTasks.add(subTasks.size(), subTask);
    }

    //testing
    public String toString()
    {
        return this.taskUUID+" "+this.userUUID+" "+this.taskName+" "+this.taskDescription+" "+this.taskPriority;
    }

    public String getTaskName()
    {
        return this.taskName;
    }
    public String getTaskDescription()
    {
        return this.taskDescription;
    }
    public int getTaskPriority()
    {
        return this.taskPriority;
    }

}
