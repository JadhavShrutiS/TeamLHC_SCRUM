//import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Sri Nandury
 */

public abstract class Task {

    public UUID taskID;
    public ArrayList<User> users;
    public String taskName;
    public String taskDescription;
    public int taskPriority;
    public ArrayList<Comment> taskComments;
    public ArrayList<String> subTasks;
    
    //existing tasks
    public Task(UUID taskUUID,ArrayList<User> users,String taskName, String taskDescription, int taskPriority, ArrayList<Comment> taskComments,ArrayList<String> subtasks)
    {
        this.taskID = taskUUID; 
        this.users = users;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;
        this.taskComments = taskComments;
        this.subTasks = subtasks;
    }

    //for new Task
    public Task(String taskName, String taskDescription, int taskPriority){
        this.taskID = UUID.randomUUID(); 
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;
        this.taskComments = null;
        this.subTasks = null;
        this.users = null;
    }

    //most helpful in setting/changing task Name
    public  void setTaskName(String taskName){
        this.taskName = taskName;
    }

    //most helpful in setting/changing task Description
    public void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;
    }

    //most helpful in setting/changing priority
    public void setPriority(int taskPriority){
        this.taskPriority = taskPriority;
    }

    //adds comments to ArrayList of comments 
    public void addComment(Comment comment){
        taskComments.add(comment);
    }

    //adds subTask to the array list of subtask for a task
    public void addSubTask(String subTask)
    {
        subTasks.add(subTask);
    }

    //adds user to a task with their uuid
    public void addUser(User user)
    {
        users.add(user);
    }
    //testing
    public String toString()
    {
        return "TASK:\n     NAME: " + this.taskName+ "\n     DESCRIPTION: "+this.taskDescription+"\n     USERS:"+this.users+"\n     PRIORITY:"+this.taskPriority+"\n     COMMENTS"+this.taskComments;
    }

    public UUID getTaskId()
    {
        return this.taskID;
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
    public ArrayList<User> getUsers()
    {
        return this.users;
    }
    public ArrayList<Comment> getTaskComments()
    {
        return this.taskComments;
    }
    public ArrayList<String> getSubtasks()
    {
        return this.subTasks;
    }

}
