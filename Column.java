import java.util.ArrayList;

/**
 * @author Sri Nandury
 */

 public class Column {

   public ArrayList<Task> taskList;
   public String name;

   Column(){

   }

   public void addTask(Task task){
    taskList.add(taskList.size(), task);
   }

   public void deleteTask(Task task){
    taskList.remove(task);
   }

   public void createTask(){
    
   }
 }