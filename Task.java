import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Sri Nandury
 */

public abstract class Task {

    public UUID taskUUID;
    public UUID userUUID;
    public String taskName;
    public String taskDescription;
    public int taskPriority;
    public ArrayList<Comment> taskComments;
    public ArrayList<String> links;
    public Date date;
    public ArrayList<Task> subTasks;

    Task(String taskName){
        this.taskUUID = UUID.randomUUID();
        this.userUUID = 
        this.taskName = taskName;
    }

    Task(String taskName, String taskDescription, int taskPriority){
        this.taskUUID = UUID.randomUUID();
        this.userUUID =
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

   // public Task addSubTask(){

    //}

}
