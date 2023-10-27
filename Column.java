import java.util.ArrayList;

/**
 * @author Sri Nandury
 */

 public class Column {

  public String name;
  public TaskList taskList;
   
  public Column(String name, TaskList taskList) 
  {
    this.name = name;
    this.taskList = taskList;
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

 }