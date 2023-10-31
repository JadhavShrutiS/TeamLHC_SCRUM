//import java.util.Scanner;

import java.util.UUID;

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
        System.out.print("Logged in as: " + currentUser.getFirstName()+" "+currentUser.getLastName());
        System.out.println(" working for Code Mission Impossible");

        Project currentProject = app.getProject("Electric Missiles");
        System.out.println("Current Project: "+currentProject.getProjectName());
        Task task = new Feature("Initialize super algorithm to detonate at warp speed","going fast is good",1,"warp speed");
        currentProject.addTask(task);
        task.addComment(new Comment("Avoid Civilians Jeff", currentUser));
        currentProject.addColumn(new Column("Abandoned", null));

        task = TaskList.getInstance().getTask("Make impossible burger possible");
        currentProject.moveTask(task, "Abandoned");


        


        //System.out.println(app.getAllProjects());

        app.logout();//to save the tasks to json file
    }
    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }
}