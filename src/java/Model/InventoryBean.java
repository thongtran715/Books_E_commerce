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
    public ArrayList<BookBean> fetchAllBooks () {
        ArrayList<BookBean> bin = new ArrayList<BookBean>();
        

        
        
        
        return bin;
    }
    
    public BookBean fetchBookByBookId(String book_id) {
        BookBean book = new BookBean();
        return book;
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
            ResultSet res = stmt.executeQuery("select book_id from Inventory");
            
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
    
    
    public int number_of_quantity_with_book_id(int book_id) {
        return 0;
    }

    public boolean validate_book_from_db_by_bookID(int book_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<BookBean> findAllBooksByManagerId(String manager_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editInventoryByBookId(String book_id, String change_book_name, int change_quantity, String change_author, String change_title, String change_description, double change_price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteInventoryItemByBookID(String book_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


  

}
