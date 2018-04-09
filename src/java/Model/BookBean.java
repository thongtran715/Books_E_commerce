package Model;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class BookBean implements Serializable {
    
    private int book_id;
    private String title;
    private String author;
    private double price;
    private String description;
    private int quantity;

    public BookBean(){}
    public BookBean(int book_id, String title, String author, double price, String description, int quantity) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    //getters
    public int getBook_id() { return book_id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }

    //setters
    public void setBook_id(int book_id) { this.book_id = book_id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPrice(double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    //other
    public BookBean findBookById(String id ) {
        
        BookBean book = new BookBean();
        // Call to db 
        book.author = "Something here";
        return book;
    }
    
    //returns arraylist filled with titles. 
    public ArrayList<String> listTitle(){
        ArrayList<String> list = new ArrayList<String>();
        try {
            // 1. Get a connection to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("select title from book");
            
            // 4. Process the result set
            while(res.next()){ list.add(res.getString(title)); }
        }
        catch (Exception e){ System.err.println(e); }
        return list;
    }
    
    //return nothing but prints out books by the input author
    public void filterAuthor(String author){
        try {
            // 1. Get a connection to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery( "SELECT book.title, book.author, book.price, book.description, book.quantity, author.author_id  "
                    + "                         FROM book, author"
                    + "                         WHERE book.author=author.author_id AND author.author_id='"+author+"'" );
            
            // 4. Process the result set
            while (res.next()){
                System.out.println( res.getString("title") + ", " + 
                                    res.getString("price") + ", " + 
                                    res.getString("description") + ", " + 
                                    res.getString("quantity") );
            }
        }
        catch (Exception e){ System.err.println(e); }
    }
    
        
    
}
