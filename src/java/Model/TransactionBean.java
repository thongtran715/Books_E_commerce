package Model;

import java.io.Serializable;
import java.util.*;
import java.sql.*;

public class TransactionBean {
    private int trans_id;
    private int user_id;
    private int book_id;
    private int book_quantity;
    private double totalsale;
    
    public TransactionBean(){}

    public TransactionBean(int user_id, int book_id, int book_quantity, double totalsale) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.book_quantity = book_quantity;
        this.totalsale = totalsale;
    }
    //getter
    public int getBook_id() { return book_id; }
    public int getBook_quantity() { return book_quantity; }
    public double getTotalsale() { return totalsale; }
    public int getTrans_id() { return trans_id; }
    public int getUser_id() { return user_id; }

    //setter
    public void setBook_id(int book_id) { this.book_id = book_id; }
    public void setBook_quantity(int book_quantity) { this.book_quantity = book_quantity; }
    public void setTotalsale(double totalsale) { this.totalsale = totalsale; }
    public void setTrans_id(int trans_id) { this.trans_id = trans_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
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
                    + "                        WHERE book.seller_id= '"+store_manager_id+"' AND TRANSACTION.book_id = book.book_id" );
            // 4. Process the result set
            while(res.next()){
                int userid = res.getInt("TRANSACTION.user_id");
                int bookid = res.getInt("TRANSACTION.book_id");
                int quan = res.getInt("TRANSACTION.book_quantity");
                Double total = (res.getDouble("book.price") * res.getInt("TRANSACTION.book_quantity"));
                //System.out.println(title +" " + author+ " " + price + " "+ des + " " +quantity +"\n");
                
                TransactionBean trans = new TransactionBean();
                trans.setBook_quantity(quan);
                trans.setUser_id(userid);
                trans.setBook_id(bookid);
                System.out.println("user: " + userid);
                System.out.println("bookid: " + bookid);
                System.out.println("quan: " + quan);                
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
            ResultSet res = stmt.executeQuery("SELECT book.seller_id, book.book_id, transaction.book_id, book.title, book.author, book.description, book.price, transaction.book_quantity "
                    + "                        FROM TRANSACTION, BOOK "
                    + "                        WHERE user_id = '"+user_id+"' AND book.book_id=transaction.book_id");
            // 4. Process the result set
            while(res.next()){
                
                String title = res.getString("title");
                String author = res.getString("author");
                Double price = res.getDouble("price");
                String des = res.getString("description");
                int quantity = res.getInt("transaction.book_quantity");
                //System.out.println(title +" " + author+ " " + price + " "+ des + " " +quantity +"\n");
                int book_id = res.getInt("book_id");
                int seller1 = res.getInt("book.seller_id");
                
                BookBean aBook = new BookBean(book_id,title,author,price,des,quantity,seller1);
                books.add(aBook);
            }     
        }
        catch (Exception e){ System.err.println(e); }
        return books;
    }

    public void checkOutCart ( int userId){
         try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT book.quantity, book.book_id, cart.book_id, cart.user_id, cart.quantity "
                    + "                        FROM CART,BOOK "
                    + "                        WHERE user_id = '"+userId+"' AND CART.book_id = Book.book_id");
            // 4. Process the result set
            int cartuserid = 0 ; 
            ArrayList<Integer> books = new ArrayList<Integer>();
            ArrayList<Integer> quantity = new ArrayList<Integer>();
            while(res.next()){
               cartuserid = res.getInt("cart.user_id");
               int cartbookid = res.getInt("cart.book_id");
               int cartquantity = res.getInt("cart.quantity");
               books.add(cartbookid);
               quantity.add(cartquantity);
               System.out.print(cartuserid);
               System.out.print(cartbookid);
               System.out.print(cartquantity);
               

            }     
            for (int i = 0 ; i < books.size(); ++i) {
                 stmt.executeUpdate("INSERT INTO TRANSACTION (user_id, book_id, book_quantity) VALUES ("+ cartuserid + ","+ books.get(i)+","+ quantity.get(i) +")");
 
            }
        }
        catch (Exception e){ System.err.println(e); }
    }

    
    public void updateQuantity() {
          try {
                // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
                // 2. Create a statement
            Statement stmt = conn.createStatement();            
                // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT BOOK.book_id, BOOK.quantity, TRANSACTION.book_quantity FROM BOOK, TRANSACTION WHERE book.book_id = transaction.book_id");            
                // 4. Process the result set
            Map<Integer, Integer> dictionary = new HashMap<Integer, Integer>();

            while(res.next()){
                int remain = res.getInt("book.quantity") - res.getInt("transaction.book_quantity");
                System.out.println("Original Field" + res.getInt("book.quantity"));
                dictionary.put(res.getInt("book.book_id"), remain);
            }
            
             for (Map.Entry<Integer,Integer> entry : dictionary.entrySet()) {
             stmt.executeUpdate("UPDATE BOOK SET quantity= "+entry.getValue()+" WHERE book_id = "+entry.getKey()+"");
             }
           }
          catch (Exception e){ System.err.println(e); }
    }
    
    public static void main(String[] args){
    TransactionBean trans = new TransactionBean() ; 
             trans.updateQuantity();
        
        
    }
}
