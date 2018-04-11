package Model;

import java.io.Serializable;
import java.sql.*;
import java.util.*;
//This is a cross reference bean
public class BookGenreBean implements Serializable {
    
   private int book_id;
   private int genre_id;

   public BookGenreBean(){}

    public BookGenreBean(int bgenre_id, int genre_id) {
        this.book_id = bgenre_id;
        this.genre_id = genre_id;
    }
    
    //getters
    public int getBgenre_id() { return book_id; }
    public int getGenre_id() { return genre_id; }

    //setters
    public void setBgenre_id(int bgenre_id) { this.book_id = bgenre_id; }
    public void setGenre_id(int genre_id) { this.genre_id = genre_id; }


}
