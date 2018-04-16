package Model;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class UserBean implements Serializable{
    
    private int user_id;
    private String name;
    private String email;
    private int typeofuser; 
    
    public UserBean(){
        user_id = 0;
        name = null;
        email = null;
        typeofuser = 0;
    
    }
    public UserBean(int user_id, String name, String email, int typeofuser){
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.typeofuser = typeofuser;
    }
    
    //getters
    public int getUser_id() { return user_id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getUserType() { return typeofuser; }

    //setters
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setType(int typeofuser) { this.typeofuser = typeofuser; }
    
    //other
    public void createUserWith(String email, String pass, String name){
        try {
                // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
                // 2. Create a statement
            Statement stmt = conn.createStatement();            
                // 3. Execute the SQL query
            stmt.executeUpdate("INSERT INTO USER (email, password, name, typeofuser) "
                    + "                         VALUE('"+email+"','"+pass+"','"+name+"',"+"0"+")");            
                // 4. Process the result set
         //   res.
           }
          catch (Exception e){ System.err.println(e); }
        
    }
    
    
    public boolean checkPassword(String password){
        Boolean checked = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            Statement stmt = conn.createStatement();
            String strCheck = "select * from user where "
                              + "email='"+email+"' and "
                              + "password='"+password+"'";
            stmt.executeQuery(strCheck);
            while(stmt.getResultSet().next()){
             checked = true;
            }
           // conn.close();
        }
        catch (Exception e){ System.err.println(e); }
        return checked;
    }
    
    public void fetchUserInfo() {
        try {
                // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
                // 2. Create a statement
            Statement stmt = conn.createStatement();            
                // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT * FROM USER WHERE email = '" +email+"'");            
                // 4. Process the result set
                while(res.next()){
                this.email = res.getString("email");
                this.typeofuser = res.getInt("typeofuser");
                this.user_id = res.getInt("user_id");
                this.name = res.getString("name");
                System.out.println("user: " + res.getInt("user_id") + " type of user: " + res.getInt("typeofuser"));
                }
           }
          catch (Exception e){ System.err.println(e); }
    }
        public void fetchUserInfoByID(int userid) {
        try {
                // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
                // 2. Create a statement
            Statement stmt = conn.createStatement();            
                // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT * FROM USER WHERE user_id = '" +userid+"'");            
                // 4. Process the result set
                while(res.next()){
                this.email = res.getString("email");
                this.typeofuser = res.getInt("typeofuser");
                this.user_id = res.getInt("user_id");
                this.name = res.getString("name");
                System.out.println("user: " + res.getInt("user_id") + " type of user: " + res.getInt("typeofuser"));
                }
           }
          catch (Exception e){ System.err.println(e); }
    }
    
    //return user_id
//    public int getUserId(){
//        int userid = 0;
//        try {
//                // 1. Get a connection to database
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
//                // 2. Create a statement
//            Statement stmt = conn.createStatement();            
//                // 3. Execute the SQL query
//            ResultSet res = stmt.executeQuery("SELECT user_id FROM USER");            
//                // 4. Process the result set
//            userid = res.getInt("user_id");            
//           }
//          catch (Exception e){ System.err.println(e); }
//        return userid;
//    }
    
//    public int getUserType(){
//        int usertype = 0;
//        try {
//                // 1. Get a connection to database
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Project2", "root", "root");           
//                // 2. Create a statement
//            Statement stmt = conn.createStatement();            
//                // 3. Execute the SQL query
//            ResultSet res = stmt.executeQuery("SELECT typeofuser FROM USER");            
//                // 4. Process the result set
//            usertype = res.getInt("typeofuser");            
//           }
//          catch (Exception e){ System.err.println(e); }
//        return usertype;
//    }
    
    public String returnName(String email){
        String username = null;
        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            // 2. Create a statement
            Statement stmt = conn.createStatement();           
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("SELECT name FROM USER WHERE email= '"+email+"'");     
            // 4. Process the result set
            username = res.getString("name");

        }
        catch (Exception e){ System.err.println(e); }
        return username;
    }
    
    public static void main(String[] args){
        UserBean user = new UserBean();
        
        user.setEmail("cmoon9@student.gsu.edu");
        user.fetchUserInfo();
        
        if(user.checkPassword("cmoon9")){
            System.out.println("it worked");
        }
        
        user.createUserWith("cmoon8@student.gsu.edu", "cmoon8", "jang");
        
        
    }
}

