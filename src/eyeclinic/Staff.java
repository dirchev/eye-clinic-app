/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic;

/**
 *
 * @author dirchev
 */
public class Staff {
    private String id;
    private String username;
    private String password;
    private String fullName;
    private String role; // "receptionist" or "optician"
    
    public Staff (String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = "receptionist";
    }
    
    public Staff (String username, String password, String fullName, String role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }
    
    public Boolean checkCredentials (String username, String password) {
        return username.equals(this.username) && password.equals(this.password);
    }
    
    public String getFullName() {
        return this.fullName;
    }
}
