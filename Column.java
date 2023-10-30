import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Sri Nandury
 */

public class Column {

  public String name;
  private ArrayList<Task> tasks;

  //Initializes a column
  public Column(String name, ArrayList<Task> tasks) 
  {
    this.name = name;
    this.tasks = tasks;
  }

  //Adds a task to a column
  public void addtask(Task task){
    tasks.add(task);
  }

  //Removes a task from a column
  public void deleteTask(Task task){
    tasks.remove(task);
  }

  //Call existing task
  public void createTask(String taskName, String description, int priority, String title, User tester) {
     if (tester != null) {
        Bug task = new Bug(taskName, description, priority, title, tester);
        tasks.add(task);
     } else {
        Feature task = new Feature(taskName, description, priority, title);
        tasks.add(task);
     }
  }

  //Create new task
  public void createTask(UUID taskUUID, ArrayList<User> users, String taskName, String taskDescription, int taskPriority, ArrayList<Comment> taskComments, ArrayList<String> subtasks, String title, User tester) {
     if (tester != null) {
        Bug task = new Bug(taskUUID, users, taskName, taskDescription, taskPriority, taskComments, subtasks, title, tester);
        tasks.add(task);
     } else {
        Feature task = new Feature(taskUUID, users, taskName, taskDescription, taskPriority, taskComments, subtasks, title);
        tasks.add(task);
     }
  }

  //Return column name
  public String getName() {
    return this.name;
  }

  //Returns all tasks
  public ArrayList<Task> getTasks() {
   return this.tasks;
  }

  //Changes name of column
  public void changeName(String name) {
   this.name = name;
  }

  //Calls a task by name
  public Task getTask(String name) {
   for (int i=0; i<tasks.size(); i++) {
      if (name == tasks.get(i).getTaskName()){
         return tasks.get(i);
      }
   }
   return null;
  }

  //Calls a task by ID
  public Task getTask(UUID taskid) {
   for (int i=0; i<tasks.size(); i++) {
      if (taskid == tasks.get(i).getTaskId()) {
         return tasks.get(i);
      }
   }
   return null; 
   }
   
   public String toString()
   {
      return "Column "+this.name+" Tasks: "+this.tasks;
   }
}