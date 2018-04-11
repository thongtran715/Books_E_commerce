package Model;

import java.io.Serializable;
import java.util.*;
import java.sql.*;

public class InventoryBean implements Serializable {
    
    private int inven_id;
    private int book_id;
    
    public InventoryBean(){}

    public InventoryBean(int inven_id, int book_id) {
        this.inven_id = inven_id;
        this.book_id = book_id;
    }
    
    //getters
    public int getInven_id() { return inven_id; }
    public int getBook_id() { return book_id; }

    //setters
    public void setInven_id(int inven_id) { this.inven_id = inven_id; }
    public void setBook_id(int book_id) { this.book_id = book_id; }
    
    public void editInventoryByBookId(String book_id, String change_title, int change_quantity, String change_author, String change_description, Double change_price){
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            stmt.executeUpdate("UPDATE BOOK "
                    + "        SET title = '"+change_title+"',quantity='"+change_quantity+"', author ='"+change_author+"', description = '"+change_description+"', price = '"+change_price+"'"
                    + "        WHERE book_id = '"+book_id+"'");
            // 4. Process the result set
    
        }
        catch (Exception e){ System.err.println(e); }
    }
    
    public BookBean fetchBookByBookId(String bookid){
        BookBean books = new BookBean();
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("select * from Book where book_id= '"+book_id+"'");
            // 4. Process the result set
            while(res.next()){
                String title = res.getString("title");
                String author = res.getString("author");
                Double price = res.getDouble("price");
                String des = res.getString("description");
                int quantity = res.getInt("quantity");
                books = new BookBean(title, author, price, des, quantity);
            }     
        }
        catch (Exception e){ System.err.println(e); }
        return books;
    }
    
    
    public int number_of_quantity_with_book_id(int book_id) {
        int count = 0;
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("select * from Book where book_id= '"+book_id+"'");
            // 4. Process the result set
            while(res.next()){
                count = res.getInt("quantity");
            }     
        }
        catch (Exception e){ System.err.println(e); }
        return count;
    }
    
    //fetch
    public ArrayList<BookBean> fetchAllBooks() {
        ArrayList<BookBean> books = new ArrayList<BookBean>();
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("select * from Book");
            // 4. Process the result set
            while(res.next()){
                String title = res.getString("title");
                String author = res.getString("author");
                Double price = res.getDouble("price");
                String des = res.getString("description");
                int quantity = res.getInt("quantity");
                BookBean aBook = new BookBean(title,author,price,des,quantity);
                books.add(aBook);
            }     
        }
        catch (Exception e){ System.err.println(e); }
        return books;
    }
    
    public ArrayList<BookBean> findAllBooksByManagerId(int manager_id) {
        ArrayList<BookBean> books = new ArrayList<BookBean>();
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("select * from Book where user_id = '"+manager_id+"'");
            // 4. Process the result set
            while(res.next()){
                String title = res.getString("title");
                String author = res.getString("author");
                Double price = res.getDouble("price");
                String des = res.getString("description");
                int quantity = res.getInt("quantity");
                BookBean aBook = new BookBean(title,author,price,des,quantity);
                books.add(aBook);
            }     
        }
        catch (Exception e){ System.err.println(e); }
        return books;
    }
    
    public void deleteInventoryItemByBookID(String book_id){
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            stmt.executeUpdate("DELETE FROM BOOK WHERE book_id = '"+book_id+"'");
            // 4. Process the result set  
        }
        catch (Exception e){ System.err.println(e); }
    }
      
    
    
    public static void main(String[] args){
        InventoryBean first = new InventoryBean();
        ArrayList<BookBean> books = new ArrayList<BookBean>();
        
        books = first.fetchAllBooks();
        
        
        for(int i = 0; i<books.size(); i++){
            System.out.println(books.get(i).getTitle());
        }
    }


}
