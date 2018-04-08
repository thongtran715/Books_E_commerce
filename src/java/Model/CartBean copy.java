import java.io.Serializable;

public class CartBean implements Serializable {
    
    private int cart_id;
    private int book_id;
    private int user_id;
    
    public CartBean(){}

    public CartBean(int cart_id, int book_id, int user_id) {
        this.cart_id = cart_id;
        this.book_id = book_id;
        this.user_id = user_id;
    }

    //getters
    public int getCart_id() { return cart_id; }
    public int getBook_id() { return book_id; }
    public int getUser_id() { return user_id; }

    //setters
    public void setCart_id(int cart_id) { this.cart_id = cart_id; }
    public void setBook_id(int book_id) { this.book_id = book_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
    
}
