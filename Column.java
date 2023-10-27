import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Sri Nandury
 */

 public class Column {

  public String name;
  private ArrayList<Task> tasks;

  public Column(String name, ArrayList<Task> tasks) 
  {
    this.name = name;
    this.tasks = tasks;
  }

  public void addtask(Task task)
  {
    tasks.add(task);
  }

  public void deleteTask(Task task){
    tasks.remove(task);
  }

  public void createTask(String taskName, String description, int prioirty) {
    Task task = new Task(taskName, description, prioirty);
    tasks.add(task);
  }   
   
  public String getName() {
    return this.name;
  }

  public ArrayList<Task> getTasks() {
   return this.tasks;
  }

  public void changeName(String name) {
   this.name = name;
  }

  public Task getTask(String name) {
   for (int i=0; i<tasks.size(); i++) {
      if (name == tasks.get(i).getTaskName()){
         return tasks.get(i);
      }
   }
   return null;
  }

  public Task getTask(UUID taskid) {
   for (int i=0; i<tasks.size(); i++) {
      if (taskid == tasks.get(i).getTaskId()) {
         return tasks.get(i);
      }
   }
   return null; 
   }
}
