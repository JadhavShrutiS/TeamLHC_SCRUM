import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Yug Desai
 */
public class ProjectBoard {
    public ArrayList<Project> projects;
    public static ProjectBoard projectBoard;
    
    public ProjectBoard()
    {
        projects = DataLoader.getProjects();
    }

    public static ProjectBoard getInstance() {
        
        if(projectBoard==null)
        {
            projectBoard = new ProjectBoard();
        }
        return projectBoard;
    }

    public void createProject(String projectName,String projectDescription)
    {
        Project project = new Project(projectName,projectDescription);
        projects.add(project);
    }

    public void createProject(UUID projectID, String projectName, String projectDescription, ArrayList<Column> columns, ArrayList<Comment> comment, ArrayList<User> users, User scrumMaster, User productOwner) {
        Project project = new Project(projectID, projectName, projectDescription, columns, comment, users, scrumMaster, productOwner);
        projects.add(project);
    }
    
    public void addProject(Project project) {
        projects.add(project);
    }

    public Project getProject(UUID uuid) {
        for (int i=0; i<projects.size(); i++) {
            if (projects.get(i).getProjectID() == uuid) {
                return projects.get(i);
            }
        }
        return null;
    }

    public Project getProject(String name) {
        for (int i=0; i<projects.size(); i++) {
            if (projects.get(i).getProjectName() == name) {
                return projects.get(i);
            }
        }
        return null;
    }

    public void addReport() {

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
