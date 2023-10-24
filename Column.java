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

   }

   public void deleteTask(Task task){

   }

   public String getName() {
      return this.name;
   }

   public void editName(String newName) {
      this.name = newName;
   }
}