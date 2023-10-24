import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Sri Nandury
 */

public abstract class Task {

    public UUID taskUUID;
    public String taskName;
    public String taskDescription;
    public ArrayList<Comment> taskComments;
    public int taskPriority;
    public ArrayList<String> links;
    public Date date;
    public ArrayList<Task> subTasks;
    public UUID userUUID;

    Task(){

    }

    Task(String taskName, String taskDescription, int taskPriority){
        this.taskUUID = UUID.randomUUID();
        this.userUUID = UUID.randomUUID();
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;

    }

    public Task createTask(Project project, Column column){
        
    }

    public  void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription){

    }

    public void addComment(Comment comment){

    }

    public void setPriorityColor(String priorityColor){

    }

    public Task addSubTask(){

    }

}
