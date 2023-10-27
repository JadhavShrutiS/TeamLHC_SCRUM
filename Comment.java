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

    public void editComment(String comment) {
        this.comment = comment;
    }

    public UUID getUserID()
    {
        return this.userID;
    }

    public Date getDate()
    {
        return this.date;
    }

    public String getComment()
    {
        return this.comment;
    }

    public String toString()
    {
        return "useriD "+this.getUserID()+" Date "+this.getDate()+" Comment "+this.getComment();
    }

}
