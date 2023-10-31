import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Shruti
 */

public class TaskList {
    private ArrayList<Task> tasks;
    private static TaskList taskList;

    //Create list of tasks
    public TaskList() 
    {
        this.tasks= DataLoader.getTasks();
    }

    //Get instance of a task list
    public static TaskList getInstance() {
        if(taskList == null)
        {
            taskList = new TaskList();
        }
        return taskList;
    }

    //Get a task from the list by its name
    public Task getTask(String taskName)
    {
        for(int i=0;i<tasks.size();i++)
        {
            if(tasks.get(i).getTaskName().equalsIgnoreCase(taskName))
            {
                return tasks.get(i);
            }
        }
        return null;
    }

    public Task getTask(UUID taskID)
    {
        for(int i=0; i<tasks.size(); i++)
        {
            if(tasks.get(i).getTaskId().equals(taskID))
                return tasks.get(i);
        }
        return null;
    }

    //Get all tasks from the list
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

    //Add a task to the list
    public boolean add(String taskName, String description, int priority, String title, User tester) {
        if (tester != null) {
           Bug task = new Bug(taskName, description, priority, title, tester);
           tasks.add(task);
        } else {
           Feature task = new Feature(taskName, description, priority, title);
           tasks.add(task);
        }
        return true;
     }

    public void saveTasks()
    {
        DataWriter.saveTasks();
    }

}
