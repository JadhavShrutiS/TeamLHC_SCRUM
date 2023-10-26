import java.util.ArrayList;

/**
 * @author Shruti
 */

public class TaskList {
    private ArrayList<Task> tasks;
    private static TaskList taskList;

    public TaskList() 
    {
        this.tasks= DataLoader.getTasks();
    }


    public static TaskList getInstance() {
        if(taskList == null)
        {
            taskList = new TaskList();
        }
        return taskList;
    }

    public Task getTask(String taskName)
    {
        for(int i=0;i<tasks.size();i++)
        {
            //User user = users.get(i);
            if(tasks.get(i).getTaskName().equalsIgnoreCase(taskName))
            {
                return tasks.get(i);
            }
        }
        return null;
    }

    public ArrayList<Task> getTasks()
    {
        return this.tasks;
    }

     //testing
    public boolean addTask(String taskName) //only checking if we can add user based on emailID!!
    {
        //loop through userlist-check for unqiue email
        //true if email is not found
        tasks = DataLoader.getTasks();
        for(int i=0;i<tasks.size();i++)
        {
            if(tasks.get(i).taskName.equalsIgnoreCase(taskName))
            {
                return false;
            }
        }
        return true;
    }
    public boolean add(String taskName, String taskDescription, int taskPriority)
    {
        Task task = new Task(taskName, taskDescription, taskPriority);
        tasks.add(task);
        return true;
    }
    public void saveTasks()
    {
        DataWriter.saveTasks();
    }
    


    



}
