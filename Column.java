import java.util.ArrayList;

/**
 * @author Sri Nandury
 */

 public class Column {

  public ArrayList<Task> taskList;
  private static UserList userList;
  public String name;
   
  public Column(String name) 
  {
    this.name = name;
  }
    
  public void addtask()
  {
    
  }

  public void deleteTask(Task task){
    taskList.remove(task);
  }

  public void createTask(String taskName){
    Task task = new Task(taskName);
    addTask(task);
  }   
   
  public String getName() {
    return this.name;
  }

  public ArrayList<Task> getTasks() {
   return this.taskList;
  }

 }