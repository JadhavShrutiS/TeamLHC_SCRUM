import java.util.ArrayList;

/**
 * @author Yug Desai
 */
public class ProjectBoard {
    public ArrayList<Project> projects;
    public ArrayList<Report> reports;
    public static ProjectBoard projectBoard;
    
    private ProjectBoard() {

    }
    public static ProjectBoard getInstance() {
        
        if(projectBoard==null)
        {
            projectBoard = new ProjectBoard();
        }
        return projectBoard;
    }
    public Project getProject(String name) {
        return projects.get(0);

    }
    public boolean add(String projectName,String description, ArrayList<User> users, ArrayList<Column> columns )
    {
        Project project = new Project(firstName, lastName, userEmail, userPassword);
        projects.add(project);
        return true;
    }
    public void addProject(Project project) 
    {

    }
    public Project viewProject() {
        return projects.get(0);

    }
    public void addReport() {

    }
    public Report viewReport() {
        return reports.get(1);

    }
    public void changeView() {

    }
    public void changeBackground() {

    }
    public int getNUmOfOpenTasks() {
        return 2;
        
    }
    public ArrayList<Project> getAllProjects()
    {
        return projects;
    }
}
