package Model;
import java.io.Serializable;
import java.util.*;
import java.sql.*;

public class TransactionBean implements Serializable{
    private int trans_id;
    private int cart_id;
    
    public TransactionBean(){}

    public TransactionBean(int trans_id, int cart_id) {
        this.trans_id = trans_id;
        this.cart_id = cart_id;
    }

    //getter
    public int getTrans_id() { return trans_id; }
    public int getCart_id() { return cart_id; }

    //setter
    public void setTrans_id(int trans_id) { this.trans_id = trans_id; }
    public void setCart_id(int cart_id) { this.cart_id = cart_id; }
    
    //other
        //call this if user decides to go through with the sale
    public void SaleCommit(){
        try {
            // 1. Get a connection to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery( "SELECT book.book_id, book.price, book.quantity, cart.cart_id, cart.book_id, user.user_id, cart.user_id "
                    + "                         FROM book, cart, user"
                    + "                         WHERE book.book_id = cart.book_id AND cart.user_id = user.user_id" );
            
            // 4. Process the result set
            String query = "UPDATE transaction SET user_id =?,book_id=?, book_price=?, book_quantity=?";
            while (res.next()){
                
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt     (1, res.getInt("cart.user_id"));
                preparedStmt.setInt     (2, res.getInt("cart.book_id"));
                preparedStmt.setDouble  (3, res.getDouble("book.price"));
                preparedStmt.setInt     (4, res.getInt("book.quantity"));
                
                preparedStmt.executeUpdate();
            }
        }
        catch (Exception e){ System.err.println(e); } 
    }
    
}
