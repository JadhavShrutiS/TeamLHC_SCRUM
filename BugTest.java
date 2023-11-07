import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BugTest {
    @BeforeClass
    public static void onetimesetup() {
        //User user = new User("trent", "waterman", "email@email.com", "12345");
        //Bug bug = new Bug("name", "description", 1, "bugs", user);
    }

    @Test
    public void testgettitle() {
        User user = new User("trent", "waterman", "email@email.com", "12345");
        Bug bug = new Bug("name", "description", 1, "bugs", user);
        assertEquals(bug.getTester(), user);
    }
    
}
