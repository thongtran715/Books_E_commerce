import java.io.Serializable;

public class InventoryBean implements Serializable {
    
    private int inven_id;
    private int book_id;
    
    public InventoryBean(){}

    public InventoryBean(int inven_id, int book_id) {
        this.inven_id = inven_id;
        this.book_id = book_id;
    }

    public int getInven_id() {
        return inven_id;
    }

    public void setInven_id(int inven_id) {
        this.inven_id = inven_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    
    
    
}
