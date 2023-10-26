import java.util.ArrayList;

/**
 * @author Sri Nandury
 */

 public class Column {

   public ArrayList<Task> taskList;
   public String name;

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