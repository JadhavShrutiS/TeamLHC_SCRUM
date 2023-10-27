/**
 * @author Sri Nandury
 */

import java.util.ArrayList;
import java.util.UUID;

public class Bug extends Task {
    
    public String bug;
    public User tester;

    Bug(String name, String description, int priority, String bug, User tester){
        super(name, description, priority);
        this.bug = bug;
        this.tester = tester;
    }

    Bug(UUID taskUUID,ArrayList<User> users,String taskName, String taskDescription, int taskPriority, ArrayList<Comment> taskComments, ArrayList<String> subtasks, String bug, User tester) {
        super(taskUUID, users, taskName, taskDescription, taskPriority, taskComments, subtasks);
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
