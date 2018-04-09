import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class AuthorBean implements Serializable {
    
    private int author_id;
    private String author;
   
    public AuthorBean(){}

    public AuthorBean(int author_id, String author) {
        this.author_id = author_id;
        this.author = author;
    }

    //getters
    public int getAuthor_id() { return author_id; }
    public String getAuthor() { return author; }

    //setters
    public void setAuthor_id(int author_id) { this.author_id = author_id; }
    public void setAuthor(String author) { this.author = author; }
    
   
}
