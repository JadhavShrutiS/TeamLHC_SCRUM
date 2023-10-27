/**
 * @author Sri Nandury
 */

import java.util.ArrayList;
import java.util.UUID;

public class Feature extends Task{
    
    public String feature;

    Feature(String name, String description, int priority, String feature){
        super(name, description, priority);
        this.feature = feature;
    }

    Feature(UUID taskUUID,ArrayList<User> users,String taskName, String taskDescription, int taskPriority, ArrayList<Comment> taskComments, ArrayList<String> subtasks, String feature) {
        super(taskUUID, users, taskName, taskDescription, taskPriority, taskComments, subtasks);
        this.feature = feature;
    }

    public String getFeature() {
        return this.feature;
    }

    public void editFeature(String feature) {
        this.feature = feature;
    }
}
