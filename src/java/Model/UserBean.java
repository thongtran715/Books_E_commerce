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
public class UserBean {
    private String name;
    private String email;
    private String user_type;
    private String user_id;
   
    public void setName (String name) {
        this.name = name;
    }
    public void setEmail (String email) {
        this.email = email;
        
    }
    public void setId (String id) {
        this.user_id = id;
        
    }
    public void setType (String type) {
        this.user_type = type;
        
    }
            
    public String getUserId () {
        return this.user_id;
    }
    
    public String getUserType () {
        return this.user_type;
    }
    public String getUserName () {
        return this.name;
    }
    
    public String getUserEmail () {
        return this.email;
    }
    
    
}
