import java.sql.Date;
import java.util.UUID;

public class Comment {
    public String comment;
    public Date date;
    public UUID userID;

    public Comment() 
    {
        this.comment = "comment";
        this.date = new java.sql.Date(System.currentTimeMillis());
    }

    //existing comment
    public Comment(UUID userID, Date date, String Comment)
    {
        this.comment = Comment;
        this.date = date;
        this.userID = userID;
    }

    public void editComment() {
        
    }
    }
