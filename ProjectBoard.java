import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Yug Desai
 */
public class ProjectBoard {
    public ArrayList<Project> projects;
    public ArrayList<Report> reports;
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
    public Project getProject(String projectName) 
    {
        for(int i=0;i<projects.size();i++)
        {
            //User user = users.get(i);
            if(projects.get(i).getProjectName().equalsIgnoreCase(projectName))
            {
                return projects.get(i);
            }
        }
        return null;

    }
    public boolean add(UUID projectID, String projectName,String projectDescription)
    {
        Project project = new Project(projectID, projectName,projectDescription);
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
