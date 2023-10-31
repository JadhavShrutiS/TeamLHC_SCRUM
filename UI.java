//import java.util.Scanner;

public class UI {
    //private Scanner scanner;
    private ProjectFACADE app;

    public void run() {
        app = new ProjectFACADE();

        app.signUp("Atticus", "Madden", "amadden@gmail.com", "12345");
        app.getTasks();
        app.logout();
        app.login("amadden@gmail.com", "12345");
        User currentUser = app.getUser();
        System.out.println("Logged in as: " + currentUser);

        System.out.println(app.getAllProjects());

        app.logout();//to save the tasks to json file
    }
    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }
}