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

  public void createTask(String taskName, String description, int priority, String type, User tester) {
   if (tester != null) {
      Task task = new Bug(taskName, description, priority, type, tester);
      tasks.add(task);
   } else {
      Task task = new Feature(taskName, description, priority, type);
      tasks.add(task);
   }
}

   public void createTask(UUID taskUUID, ArrayList<UUID> userIDs, String taskName, String taskDescription, int taskPriority, ArrayList<Comment> taskComments, ArrayList<String> subtasks, String type, User tester) {
      if (tester != null) {
      Task task = new Bug(taskUUID, userIDs, taskName, taskDescription, taskPriority, taskComments, subtasks, type, tester);
      tasks.add(task);
   } else {
      Task task = new Feature(taskUUID, userIDs, taskName, taskDescription, taskPriority, taskComments, subtasks, type);
      tasks.add(task);
   }
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
