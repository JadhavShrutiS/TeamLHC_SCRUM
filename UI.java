import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private ProjectFACADE app;

    public void run() {
        app = new ProjectFACADE();

        app.signUp("bobby", "smith", "bsmith@gmail.com", "12345");
        app.logout();
        app.login("bsmith@gmail.com", "12345");
        User currentUser = app.getUser();
        System.out.println("Logged in as: " + currentUser);

        //Task Related Checks
        app.addTask("Hehe","Hehe",1);
        Task currentTask = app.getTask("Hehe");
        System.out.println("Task "+ currentTask);
        System.out.println(app.getTasks());
        app.addTask("Trial", "Again", 3);
        System.out.println(app.getTask("Trial"));
        System.out.println(app.getTasks());
        app.logout();//to save the tasks to json file
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