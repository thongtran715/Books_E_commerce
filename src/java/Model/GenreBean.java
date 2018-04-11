package Model;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class GenreBean implements Serializable {
   
    private int genre_id;
    private String genre;
    
    public GenreBean(){}

    public GenreBean(int genre_id, String genre) {
        this.genre_id = genre_id;
        this.genre = genre;
    }

    //getters
    public int getGenre_id() { return genre_id; }
    public String getGenre() { return genre; }

    //setters
    public void setGenre_id(int genre_id) { this.genre_id = genre_id; }
    public void setGenre(String genre) { this.genre = genre; }
    
    //other
    public void filterGenre(int genre){
        try {
            // 1. Get a connection to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery( "SELECT book.book_id, book.title, book.author, book.price, book.description, book.quantity, genre.genre  "
                    + "                         FROM book, genre, book_genre "
                    + "                         WHERE book.book_id = book_genre.book_id AND book_genre.genre_id = genre.genre_id AND genre.genre = '" + genre +"'" );
            
            // 4. Process the result set
            while (res.next()){
                System.out.println( res.getString("title") + ", " + 
                                    res.getString("author") + ", " +
                                    res.getString("price") + ", " + 
                                    res.getString("description") + ", " + 
                                    res.getString("quantity") );
            }
        }
        catch (Exception e){ System.err.println(e); }
    }
}
