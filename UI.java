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
    }

    public void displayMainMenu() {

    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }
}