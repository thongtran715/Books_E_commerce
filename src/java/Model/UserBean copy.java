import java.io.Serializable;

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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTypeofuser() {
        return typeofuser;
    }

    public void setTypeofuser(int typeofuser) {
        this.typeofuser = typeofuser;
    }
    

    
}

