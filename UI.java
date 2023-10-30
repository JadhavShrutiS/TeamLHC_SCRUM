//import java.util.Scanner;

public class UI {
    //private Scanner scanner;
    private ProjectFACADE app;

    public void run() {
        app = new ProjectFACADE();

        app.signUp("Atticus", "Madden", "amadden@gmail.com", "12345");
        app.logout();
        app.login("amadden@gmail.com", "12345");
        User currentUser = app.getUser();
        System.out.println("Logged in as: " + currentUser);

        //Task Related Checks
        app.addTask("Trial", "Again", 3);
        //System.out.println(app.getTask("Trial"));
        //System.out.println(app.getTasks());

        System.out.println(app.getAllProjects());

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