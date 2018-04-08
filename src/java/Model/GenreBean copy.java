import java.io.Serializable;

public class GenreBean implements Serializable {
   
    private int genre_id;
    private String genre;
    
    public GenreBean(){}

    public GenreBean(int genre_id, String genre) {
        this.genre_id = genre_id;
        this.genre = genre;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
}
