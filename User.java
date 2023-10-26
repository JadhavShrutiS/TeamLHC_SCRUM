import java.util.UUID;

public class User {
    private UUID uuid;
    private String firstName;
    private String lastName;
    public String userEmail;
    private String userPassword;
   
    //for demo
    public User()
    {

    }
    
    //for existing user
    public User(UUID uuid, String firstName, String lastName, String userEmail, String userPassword) {
       this.uuid = uuid;
       this.firstName = firstName;
       this.lastName = lastName;
       this.userEmail = userEmail;
       this.userPassword = userPassword;
    }

    //for new user
    public User(String firstName, String lastName, String userEmail, String userPassword) {
    
       this.uuid = UUID.randomUUID();
       this.firstName = firstName;
       this.lastName = lastName;
       this.userEmail = userEmail;
       this.userPassword = userPassword;
    }

    public String toString()
    {
        return this.uuid+" "+this.firstName+" "+this.lastName+" "+this.userEmail+" "+this.userPassword;
    }

    public UUID getId() {
        return this.uuid;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmailID() {
        return this.userEmail;
    }

    public String getPassword() {
        return this.userPassword;
    }
}
