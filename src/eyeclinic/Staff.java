package eyeclinic;

import java.io.Serializable;

/**
 * Implementation of Staff interface.
 * <p>
 * Holds all fields, needed for a eye clinic's staff member.
 * @author dirchev
 */
public class Staff implements Serializable {
    private final String username;
    private final String password;
    private final String fullName;
    private final String role; // "receptionist" or "optician"
    
    /**
     * Creates new receptionist.
     * @param username username of the staff member
     * @param password the password of the staff member
     * @param fullName the full name of the staff member
     */
    public Staff (String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = "receptionist";
    }
    
    /**
     * Creates new staff member.
     * @param username username of the staff member
     * @param password the password of the staff member
     * @param fullName the full name of the staff member
     * @param role the staff member's role. Can be "receptionist" or "optician"
     */
    public Staff (String username, String password, String fullName, String role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }
    
    /**
     * Checks if credentials match the member's credentials
     * @param username username to check
     * @param password password to check
     * @return true if the credentials match or false if the don't
     */
    public Boolean checkCredentials (String username, String password) {
        return username.equals(this.username) && password.equals(this.password);
    }
    
    /**
     * Returns the full name of the staff member
     * @return full name of the staff member
     */
    public String getFullName() {
        return this.fullName;
    }
}
