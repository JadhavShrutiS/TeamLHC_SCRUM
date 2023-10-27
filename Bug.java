/**
 * @author Sri Nandury
 */

 import java.util.ArrayList;
import java.util.UUID;

public class Bug extends Task {
    
    public String bug;
    public User tester;
    public ArrayList<String> reproductiveSteps;

    Bug(String name, String description, int priority, String bug){
        super(name, description, priority);
        this.bug = bug;
        this.tester = null;
        this.reproductiveSteps = null;
    }

    Bug(UUID taskID, String taskName, String taskDescription, int taskPriority, String bug) {
        super(taskID, taskName, taskDescription, taskPriority);
        this.bug = bug;
        this.tester = null;
        this.reproductiveSteps = null;
    }

    Bug(UUID taskUUID,ArrayList<UUID> userIDs,String taskName, String taskDescription, int taskPriority, ArrayList<Comment> taskComments, ArrayList<String> subtasks, String bug, User tester, ArrayList<String> reproductiveSteps) {
        super(taskUUID, userIDs, taskName, taskDescription, taskPriority, taskComments, subtasks);
        this.bug = bug;
        this.tester = tester;
        this.reproductiveSteps = reproductiveSteps;
    }

    public String getBug() {
        return this.bug;
    }
}
