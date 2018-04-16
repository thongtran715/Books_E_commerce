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
    private int sellerid;

    public BookBean(){}
    public BookBean(int book_id, String title, String author, double price, String description, int quantity, int sellerid) {
        this.title = title;
        this.book_id = book_id;
        this.author = author;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.sellerid = sellerid;
    }

    //getters
    public int getBook_id() { return book_id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }
    public int getSellerid() { return quantity; }


    //setters
    public void setBook_id(int book_id) { this.book_id = book_id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPrice(double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setSellerid(int sellerid) { this.sellerid = sellerid; }

    //other
    
    public BookBean getBookById (int book_id){
            BookBean book = new BookBean();
        try {
                // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
                // 2. Create a statement
            Statement stmt = conn.createStatement();            
                // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT * FROM BOOK, AUTHOR WHERE book.author = author.author_id AND book_id = '" +book_id+"'");            
                // 4. Process the result set
                while(res.next()){
                     book.setTitle(res.getString("title"));
                     book.setAuthor(res.getString("author.author"));
                     book.setPrice(res.getDouble("price"));
                     
                }
           }
          catch (Exception e){ System.err.println(e); }
    return book;
    }
    
    public boolean findBookById(String book_id){
        
        boolean result = false;
        try {
                // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
                // 2. Create a statement
            Statement stmt = conn.createStatement();            
                // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT * FROM BOOK WHERE book_id = '" +book_id+"'");            
                // 4. Process the result set
                while(res.next()){
                    result = true;
                }
           }
          catch (Exception e){ System.err.println(e); }
    return result;
    }
    
    
    
    //returns arraylist filled with titles. 
 
    public ArrayList<String> listTitle(){
        ArrayList<String> list = new ArrayList<String>();
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("select title from book");
            // 4. Process the result set
            while(res.next()){ list.add(res.getString("title")); }
        }
        catch (Exception e){ System.err.println(e); }
        return list;
    }
    
    //return nothing but prints out books by the input author
    public void filterAuthor(String author){
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
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

    public void updateBookQuantityByStoreManager(int book_id, int seller_id, int quantity) {
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            stmt.executeUpdate("UPDATE BOOK SET quantity = '"+quantity+"' WHERE book_id='"+book_id+"' AND seller_id ='"+seller_id+"'");
            // 4. Process the result set
        }
        catch (Exception e){ System.err.println(e); }
    }
        

    public void updateBookTitleByStoreManager(int book_id, int seller_id, String title) {
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            stmt.executeUpdate("UPDATE BOOK SET title = '"+title+"' WHERE book_id='"+book_id+"' AND seller_id ='"+seller_id+"'");
            // 4. Process the result set
        }
        catch (Exception e){ System.err.println(e); }
    }    

    public void updateBookDescByStoreManager(int book_id, int seller_id, String desc) {
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            stmt.executeUpdate("UPDATE BOOK SET description = '"+desc+"' WHERE book_id='"+book_id+"' AND seller_id ='"+seller_id+"'");
            // 4. Process the result set
        }
        catch (Exception e){ System.err.println(e); }
    }  

    public void updateBookPriceByStoreManager(int book_id, int seller_id, double price) {
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            stmt.executeUpdate("UPDATE BOOK SET price = '"+price+"' WHERE book_id='"+book_id+"' AND seller_id ='"+seller_id+"'");
            // 4. Process the result set
        }
        catch (Exception e){ System.err.println(e); }
    }  

    public void updateBookAuthorByStoreManager(int book_id, int seller_id, String author) {
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            stmt.executeUpdate("INSERT INTO AUTHOR (author) VALUE ('"+author+"')");
            
            stmt.executeUpdate("UPDATE BOOK,AUTHOR SET book.author = author.author_id WHERE author.author = '"+author+"' AND book_id='"+book_id+"' AND seller_id ='"+seller_id+"'");
            // 4. Process the result set
        }
        catch (Exception e){ System.err.println(e); }
    }  
    
    public void addBookbyManager(String newtitle, String newauthor, double newprice, String desc, int quan, int sellerid) {
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            stmt.executeUpdate("INSERT INTO AUTHOR (author) VALUE ('"+newauthor+"')");
            ResultSet res = stmt.executeQuery("SELECT * FROM author where author = '"+newauthor+"'");
            int authorid = 0;
            while(res.next()){
                authorid = res.getInt("author.author_id");
            }
            stmt.executeUpdate("INSERT INTO BOOK (title, author, price, description, quantity, seller_id) "
                    + "         VALUES('"+newtitle+"','"+authorid+"','"+newprice+"','"+desc+"','"+quan+"','"+sellerid+"')");
            // 4. Process the result set
        }
        catch (Exception e){ System.err.println(e); }
    }  
    
//        public void updateBookAfterSold( int quantity) {
//        try {
//            // 1. Get a connection to database
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
//            // 2. Create a statement
//            Statement stmt = conn.createStatement();
//            // 3. Execute the SQL query
//            stmt.executeUpdate("UPDATE BOOK SET author= '"+author+"' WHERE book_id='"+book_id+"' AND seller_id ='"+seller_id+"'");
//            // 4. Process the result set
//        }
//        catch (Exception e){ System.err.println(e); }
//    }  

        public static void main(String[] args){
            BookBean book = new BookBean();
            book.addBookbyManager("kokoko", "sdd", 3.3, "sadas", 2, 1);
    }

}
