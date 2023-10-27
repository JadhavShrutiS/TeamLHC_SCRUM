/**
 * @author Sri Nandury
 */

import java.util.ArrayList;
import java.util.UUID;

public class Bug extends Task {
    
    public String bug;
    public User tester;

    Bug(String name, String description, int priority, String bug){
        super(name, description, priority);
        this.bug = bug;
        this.tester = null;
    }

    Bug(UUID taskID, String taskName, String taskDescription, int taskPriority, String bug) {
        super(taskID, taskName, taskDescription, taskPriority);
        this.bug = bug;
        this.tester = null;
    }

    Bug(UUID taskUUID,ArrayList<UUID> userIDs,String taskName, String taskDescription, int taskPriority, ArrayList<Comment> taskComments, ArrayList<String> subtasks, String bug, User tester) {
        super(taskUUID, userIDs, taskName, taskDescription, taskPriority, taskComments, subtasks);
        this.bug = bug;
        this.tester = tester;
    }

    public String getBug() {
        return this.bug;
    }

    public void editBug(String bug) {
        this.bug = bug;
    }

    public User getTester() {
        return tester;
    }

    public void editTester(User tester) {
        this.tester = tester;
    }
}
