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
    
    //other
    public ArrayList<Integer> listAll(String book){
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            // 1. Get a connection to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("select book_id from Inventory where");
            
            // 4. Process the result set
            while(res.next()){
                list.add(res.getInt(book_id));
            }
         
        
        }
        catch (Exception e){
            System.err.println(e);
        }
        return list;
    }
    
}
