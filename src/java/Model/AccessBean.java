/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ThongTran
 */
public class AccessBean {
    
    
    private String email;
    private String password;
    public AccessBean() {
        super();
    }
    
    
    
    public String getUserEmail () {
        return email;
    }
    public void emailUserName(String email) {
        this.email = email;
    }
    public boolean logInToDb(String password) {
        // Call the db 
        // QUerry the db 
        return true;
    }
 
    
    public UserBean fetchUserInfo() {
        UserBean user = new UserBean () ;
        user.setName("Hola");
        return user;
    }
    
    
    public void createUserWith(String email, String password, String name){
        
    }
}
