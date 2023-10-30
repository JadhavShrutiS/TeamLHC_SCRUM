import java.util.ArrayList;

/**
 * @author Sri Nandury
 */

 public class Column {

   public ArrayList<Task> taskList;

   public ArrayList<Task> getTaskList() {
    return this.taskList;
  }

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


  public void createTask(String taskName, String description, int priority, String title, User tester) {
   if (tester != null) {
      Bug task = new Bug(taskName, description, priority, title, tester);
      tasks.add(task);
   } else {
      Feature task = new Feature(taskName, description, priority, title);
      tasks.add(task);
   }
}

   public void createTask(UUID taskUUID, ArrayList<User> users, String taskName, String taskDescription, int taskPriority, ArrayList<Comment> taskComments, ArrayList<String> subtasks, String title, User tester) {
      if (tester != null) {
      Bug task = new Bug(taskUUID, users, taskName, taskDescription, taskPriority, taskComments, subtasks, title, tester);
      tasks.add(task);
   } else {
      Feature task = new Feature(taskUUID, users, taskName, taskDescription, taskPriority, taskComments, subtasks, title);
      tasks.add(task);
   }
   }
   


   public String getName() {
    return this.name;
  }

  Column(String name){
    this.name = name;
   }

   public void addTask(Task task){
    taskList.add(taskList.size(), task);
   }

   public void deleteTask(Task task){
    taskList.remove(task);
   }

   public void createTask(String taskName){
    Task task = new Task(taskName);
    addTask(task);
   }
 }