import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Sri Nandury
 */

public abstract class Task {

    public String taskName;
    public String taskDescription;
    public ArrayList<Comments> taskComments;
    public int taskPriority;
    public ArrayList<String> links;
    public ArrayList<String> comments; //why twice?
    public Date date;
    public ArrayList<Task> subTasks;
    //UUID for task, project and columns??
    //task created by user's UUID 
    //assignee user UUID

    Task(){

    }

    public Task createTask(Column column){

    }

    public Task createTask(Project project, Column column){

    }

    public  void setTaskName(String taskName){

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
