import java.io.Serializable;
import java.util.*;

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
        
    }
    
}
