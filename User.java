import java.util.UUID;

public class User {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userPassword;
   
    public User(UUID uuid, String firstName, String lastName, String userEmail, String userPassword) {
       this.uuid = uuid;
       this.firstName = firstName;
       this.lastName = lastName;
       this.userEmail = userEmail;
       this.userPassword = userPassword;
    }
    
    protected void login() {
        
    }

    protected void logout() {

    }
}
