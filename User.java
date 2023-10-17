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
    
       this.firstName = firstName;
       this.lastName = lastName;
       this.userEmail = userEmail;
       this.userPassword = userPassword;
    }
    
    protected void login() {
        
    }

    protected void logout() {

    }

    public String toString()
    {
        return this.uuid+" "+this.firstName+" "+this.lastName+" "+this.userEmail+" "+this.userPassword;
    }
}
