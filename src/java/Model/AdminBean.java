package Model;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class AdminBean implements Serializable {
    
    private int user_id;
    private int typeofuser;
   
    public AdminBean(){}

    public AdminBean(int user_id, int typeofuser) {
        this.user_id = user_id;
        this.typeofuser = typeofuser;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTypeofuser() {
        return typeofuser;
    }

    public void setTypeofuser(int typeofuser) {
        this.typeofuser = typeofuser;
    }

    public boolean checkIfUserAdmin(String user_id){
        
        boolean result = false;
        try {
                // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
                // 2. Create a statement
            Statement stmt = conn.createStatement();            
                // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT * FROM user WHERE user_id = '" +user_id+"' AND typeofuser = 2");            
                // 4. Process the result set
                while(res.next()){
                    result = true;
                }
           }
          catch (Exception e){ System.err.println(e); }
        return result;
    }
    
    public void deleteUserById(String user_id){
        
        try {
                // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
                // 2. Create a statement
            Statement stmt = conn.createStatement();            
                // 3. Execute the SQL query
                
            stmt.executeUpdate("DELETE FROM BOOK WHERE seller_id = '" +user_id+"'");            
            stmt.executeUpdate("DELETE FROM CART WHERE user_id = '" +user_id+"'");            
            stmt.executeUpdate("DELETE FROM USER WHERE user_id = '" +user_id+"'");            
                // 4. Process the result set
            
           }
          catch (Exception e){ System.err.println(e); }
    }
    
    public ArrayList<UserBean> getAllUser() {
        ArrayList<UserBean> users = new ArrayList<UserBean>();
        try {
                // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
                // 2. Create a statement
            Statement stmt = conn.createStatement();            
                // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT * FROM USER WHERE typeofuser != 2");            
                // 4. Process the result set
                while(res.next()){
                int userid2 = res.getInt("user_id");
                String email2 = res.getString("email");
                String name2 = res.getString("name");
                int typeofuser2 = res.getInt("typeofuser");
                UserBean adminuser = new UserBean(userid2, email2, name2, typeofuser2);
                users.add(adminuser);
                }
           }
          catch (Exception e){ System.err.println(e); }
        return users;
    }

    public ArrayList<BookBean> getAllBooks() {
ArrayList<BookBean> books = new ArrayList<BookBean>();
        try {
                // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
                // 2. Create a statement
            Statement stmt = conn.createStatement();            
                // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT * FROM BOOK");            
                // 4. Process the result set
                while(res.next()){
                int book1 = res.getInt("book_id");
                String title1 = res.getString("title");
                String author1 = res.getString("author");
                double price1 = res.getDouble("price");
                String des1 = res.getString("description");
                int quantity1 = res.getInt("quantity");
                int seller1 = res.getInt("seller_id");
                
                BookBean allbooks = new BookBean(book1, title1, author1, price1, des1, quantity1, seller1);
                books.add(allbooks);
                }
           }
          catch (Exception e){ System.err.println(e); }
        return books;
    }    

    public void deleteBookByBookId(String book_id) {
            try {
                // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
                // 2. Create a statement
            Statement stmt = conn.createStatement();            
                // 3. Execute the SQL query
            stmt.executeUpdate("DELETE FROM CART WHERE book_id = '" +book_id+"'");            

            stmt.executeUpdate("DELETE FROM BOOK WHERE book_id = '" +book_id+"'");            
                // 4. Process the result set

           }
          catch (Exception e){ System.err.println(e); }


    }
    
     public void updateUserType(int usertype, int userid){
        
        try {
                // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
                // 2. Create a statement
            Statement stmt = conn.createStatement();            
                // 3. Execute the SQL query
                
            stmt.executeUpdate("UPDATE USER SET typeofuser ='" + usertype +"' WHERE user_id = '" + userid + "'");            
               
                // 4. Process the result set
            
           }
          catch (Exception e){ System.err.println(e); }
    }
    
    
    
    
    public static void main(String[] args){
    AdminBean trans = new AdminBean() ; 
             trans.deleteBookByBookId("5");
    }
            
}