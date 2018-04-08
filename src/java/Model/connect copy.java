import java.sql.*;
public class connect {
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String PATH =
            "jdbc:mysql://localhost:3306/Project2";
    private Connection conn = null;

    
    public void setConnection(){
        try {
            conn = DriverManager.getConnection(PATH,USERNAME,PASSWORD);
            System.out.println("Connected");
        }catch (SQLException e){
            System.err.println(e);
        }
        
    }
        public boolean checkEmailandPass(String email, String password){
        try{
            setConnection();
            Statement stmt = conn.createStatement();
            String strCheck = "select * from user where "
                    + "username='"+email+"' and "
                    + "password='"+password+"'";
            stmt.executeQuery(strCheck);
            while(stmt.getResultSet().next()){
                return true;
            }
            conn.close();
        }
        catch (SQLException e){
            System.err.println(e);
        }
        return false;
    }
    
   
  
}
