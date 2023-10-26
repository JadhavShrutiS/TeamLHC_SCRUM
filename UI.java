import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private ProjectFACADE facade;

    public void run() {
        ProjectFACADE app = new ProjectFACADE();

        app.signUp("bobby", "smith", "bsmith@gmail.com", "12345");
        app.logout();
        app.login("bsmith@gmail.com", "12345");
        User currentUser = app.getUser();

        
        System.out.println("Logged in as: " + currentUser);
        app.addTask("Hehe","Hehe","1");
        
        Task currentTask = app.getTask("Hehe");
        
        System.out.println("Task "+ currentTask);
        
        System.out.println(app.getTasks());

        app.addTask("Trial", "Again", "3");
        System.out.println(app.getTask("Trial"));

        System.out.println(app.getTasks());
        app.logout();
    }

    public void displayMainMenu() {

    }
    public void runDW()
    {

    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }
}