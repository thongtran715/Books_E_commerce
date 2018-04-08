import java.io.Serializable;

public class BookBean implements Serializable {
    
    private int book_id;
    private String title;
    private String author;
    private double price;
    private String description;
    private int quantity;

    public BookBean(){}
    
    public BookBean(int book_id, String title, String author, double price, String description, int quantity) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
