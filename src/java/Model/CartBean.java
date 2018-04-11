package Model;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class CartBean implements Serializable {
    
    private int cart_id;
    private int book_id;
    private int user_id;
    private int quantity;
    
    public CartBean(){}

    public CartBean(int cart_id, int book_id, int user_id, int quantity) {
        this.cart_id = cart_id;
        this.book_id = book_id;
        this.user_id = user_id;
        this.quantity = quantity;
    }

    //getters
    public int getCart_id() { return cart_id; }
    public int getBook_id() { return book_id; }
    public int getUser_id() { return user_id; }
    public int getQuantity() { return quantity; }


    //setters
    public void setCart_id(int cart_id) { this.cart_id = cart_id; }
    public void setBook_id(int book_id) { this.book_id = book_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public void setQuantity(int user_id) { this.quantity = quantity; }

    //other
    
    public void delete_cart(int userid, int bookid){
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            stmt.executeUpdate("DELETE FROM CART WHERE book_id = '"+bookid+"' AND user_id = '"+userid+"'");
            // 4. Process the result set

        }
        catch (Exception e){ System.err.println(e); }
        
    }
    
        public void clearCartForUserId(int userid){
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            stmt.executeUpdate("DELETE FROM CART WHERE user_id = '"+userid+"'");
            // 4. Process the result set

        }
        catch (Exception e){ System.err.println(e); }
        
    }
    
    public ArrayList<BookBean> fetchAllCartBooksByUserId(int user_id) {
        ArrayList<BookBean> books = new ArrayList<BookBean>();
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT book.book_id, cart.book_id, book.title, book.author, book.description, book.price, cart.quantity "
                    + "                        FROM CART, BOOK "
                    + "                        WHERE user_id = '"+user_id+"' AND book.book_id = cart.book_id");
            // 4. Process the result set
            while(res.next()){
                String title = res.getString("title");
                String author = res.getString("author");
                Double price = res.getDouble("price");
                String des = res.getString("description");
                int quantity = res.getInt("cart.quantity");
                //System.out.println(title +" " + author+ " " + price + " "+ des + " " +quantity +"\n");
                BookBean aBook = new BookBean(title,author,price,des,quantity);
                books.add(aBook);
            }     
        }
        catch (Exception e){ System.err.println(e); }
        return books;
    }
    
    public void update_quantity_by(int userid, int bookid, int quantity){
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            stmt.executeUpdate("UPDATE CART SET quantity = '"+quantity+"' WHERE book_id = '"+bookid+"' AND user_id = '"+userid+"'");
            // 4. Process the result set

        }
        catch (Exception e){ System.err.println(e); }
    }
    
 
    public double returnTotal(){
        double totalcost = 0;
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT book.book_id, book.price, book.quantity, cart.book_id"
                    + "                       FROM BOOK, CART"
                    + "                       WHERE book.book_id=cart.book_id" );
            // 4. Process the result set
            totalcost = res.getDouble("book.price") *res.getInt("book.quantity");

        }
        catch (Exception e){ System.err.println(e); }
        return totalcost;
    }
    
    //main
    public static void main(String[] args){
        CartBean test = new CartBean();
        ArrayList<BookBean> books = new ArrayList<BookBean>();
       // books = test.fetchAllCartBooksByUserId("3");
        
    }


}
