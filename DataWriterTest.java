import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @author Shruti
 */
class DataWriterTest {
	private UserList users = UserList.getInstance();
	private ArrayList<User> userList = users.getUsers();
	
	@BeforeEach
	public void setup() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	
	@Test
	void testWritingZeroUsers() {
		userList = DataLoader.getUsers();
		assertEquals(0, userList.size());
	}

	@Test
	void testWritingOneUser() {
		userList.add(new User("amy","smith","a1@email.com","a1"));
		DataWriter.saveUsers();
		assertEquals("a1@email.com", DataLoader.getUsers().get(0).getEmailID());
	}
	
	@Test
	void testWritingFiveUsers() {
		userList.add(new User("amy","smith","a1@email.com","a1"));
		userList.add(new User("amy2","smith","a2@email.com","a2"));
		userList.add(new User("amy3","smith","a3@email.com","a3"));
		userList.add(new User("amy4","smith","a4@email.com","a4"));
		userList.add(new User("amy5","smith","a5@email.com","a5"));
		
        
        DataWriter.saveUsers();
		assertEquals("a5@email.com", DataLoader.getUsers().get(4).getEmailID());
	}
	
    @Test
    void testWritingEmptyUser()
    {
        userList.add(new User("","","",""));
        DataWriter.saveUsers();
        assertEquals("",DataLoader.getUsers().get(0).getEmailID());
    }

    @Test
    void testWritingNullUser()
    {
        userList.add(new User(null,null,null,null));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.getUsers().get(0).getEmailID());
    }
	
}