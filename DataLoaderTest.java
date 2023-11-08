import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * @author Shruti
 */

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {
    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();

    @BeforeClass
    public void onetimesetup() {
        
    }

    @AfterClass
	public void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public void setup() {
        //runs before each test
        userList.clear();
        userList.add(new User("Shruti", "Jadhav", "sj@email.com", "1234"));
        userList.add(new User("shruti1", "jadhav1", "sj1@email.com", "5678"));
        DataWriter.saveUsers();

		
	}
	
	@AfterEach
	public void tearDown() {
		//runs after each test
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
	}

    @Test
    void testGetUsersSize()
    {
        userList = DataLoader.getUsers();
        assertEquals(2,userList.size());
    }

    @Test
    void testGetUsersSizeZero()
    {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        assertEquals(0,userList.size());
    }

    @Test
    void testGetUserFirstUserEmail()
    {
        userList = DataLoader.getUsers();
        assertEquals("sj@email.com",userList.get(0).getEmailID());
    }

    
}
