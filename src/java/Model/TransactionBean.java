package Model;

import java.io.Serializable;
import java.util.*;
import java.sql.*;

public class TransactionBean {
    private int trans_id;
    private int cart_id;
    private int user_id;
    private double book_price;
    private int book_quantity;
    private double totalsale;
    
    public TransactionBean(){}

    public TransactionBean(int cart_id, int user_id, double book_price, int book_quantity, double totalsale) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.book_price = book_price;
        this.book_quantity = book_quantity;
        this.totalsale = totalsale;
    }
    //getter
    public int getUser_id() { return user_id; }
    public double getBook_price() { return book_price; }
    public int getBook_quantity() { return book_quantity; }
    public double getTotalsale() { return totalsale; }
    public int getTrans_id() { return trans_id; }
    public int getCart_id() { return cart_id; }

    //setter
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public void setBook_price(double book_price) { this.book_price = book_price; }
    public void setBook_quantity(int book_quantity) { this.book_quantity = book_quantity; }
    public void setTotalsale(double totalsale) { this.totalsale = totalsale; }
    public void setTrans_id(int trans_id) { this.trans_id = trans_id; }
    public void setCart_id(int cart_id) { this.cart_id = cart_id; }
    
    //other
    public ArrayList<TransactionBean> findAllSaleFromUserId(int store_manager_id){
        ArrayList tranbean = new ArrayList();
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT * "
                    + "                        FROM TRANSACTION, BOOK "
                    + "                        WHERE user_id = '"+store_manager_id+"'");
            // 4. Process the result set
            while(res.next()){
                int cartid = res.getInt("cart_id");
                int userid = res.getInt("user_id");
                Double price = res.getDouble("book_price");
                int quan = res.getInt("book_quantity");
                Double total = (res.getDouble("book_price") + res.getInt("book_quantity"));
                //System.out.println(title +" " + author+ " " + price + " "+ des + " " +quantity +"\n");
                TransactionBean trans = new TransactionBean(cartid, userid, price, quan, total);
                tranbean.add(trans);
            }     
        }
        catch (Exception e){ System.err.println(e); }
        return tranbean;
    }
    
    public ArrayList<BookBean> fetchAllBooksHistoryByUserId(int user_id) {
        ArrayList<BookBean> books = new ArrayList<BookBean>();
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT book.book_id, transaction.book_id, book.title, book.author, book.description, book.price, transaction.book_quantity "
                    + "                        FROM TRANSACTION, BOOK "
                    + "                        WHERE user_id = '"+user_id+"' AND book.book_id=transaction.book_id");
            // 4. Process the result set
            while(res.next()){
                String title = res.getString("title");
                String author = res.getString("author");
                Double price = res.getDouble("price");
                String des = res.getString("description");
                int quantity = res.getInt("transacation.book_quantity");
                //System.out.println(title +" " + author+ " " + price + " "+ des + " " +quantity +"\n");
                BookBean aBook = new BookBean(title,author,price,des,quantity);
                books.add(aBook);
            }     
        }
        catch (Exception e){ System.err.println(e); }
        return books;
    }

    
        //call this if user decides to go through with the sale
    public void saleCommit(){
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");            
            // 2. Create a statement
            Statement stmt = conn.createStatement();            
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery( "SELECT book.book_id, book.price, book.quantity, cart.cart_id, cart.book_id, user.user_id, cart.user_id "
                    + "                         FROM BOOK, CART, USER"
                    + "                         WHERE book.book_id = cart.book_id AND cart.user_id = user.user_id" );
            
            // 4. Process the result set
            String query = "UPDATE transaction SET user_id =?,book_id=?, book_price=?, book_quantity=?, totalsale=?";
            while (res.next()){
                
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt     (1, res.getInt("cart.user_id"));
                preparedStmt.setInt     (2, res.getInt("cart.book_id"));
                preparedStmt.setDouble  (3, res.getDouble("book.price"));
                preparedStmt.setInt     (4, res.getInt("book.quantity"));
                preparedStmt.setDouble  (5, (res.getDouble("book.price") * res.getDouble("book.quantity")));
                
                preparedStmt.executeUpdate();
            }
        }
        catch (Exception e){ System.err.println(e); } 
    }
    
    public static void main(String[] args){
        TransactionBean test = new TransactionBean();
        
    }
}
