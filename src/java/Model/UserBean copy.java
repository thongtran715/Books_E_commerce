import java.io.Serializable;
import java.sql.*;

public class UserBean implements Serializable{
    
    private int user_id;
    private String name;
    private String email;
    private int typeofuser; 
    
    public UserBean(){}
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
    public int getTypeofuser() { return typeofuser; }

    //setters
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setTypeofuser(int typeofuser) { this.typeofuser = typeofuser; }
    
    //other
    public String returnName(String email){
        try {
            // 1. Get a connection to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project2", "root", "root");
            
            // 2. Create a statement
            Statement stmt = conn.createStatement();
            
            // 3. Execute the SQL query
            ResultSet res = stmt.executeQuery("select name from user where " +
                    "email =' " + email + "'");
            
            // 4. Process the result set
            return res.getString(name);
            
         
        
        }
        catch (Exception e){
            System.err.println(e);
        }
        return null;
    }

    
}

