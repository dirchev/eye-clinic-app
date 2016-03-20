/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Models;

import eyeclinic.Staff;
import java.util.ArrayList;

/**
 * StaffModel takes care of storing all staff members in the system
 * @author dirchev
 */
public class StaffModel {
    private static final ArrayList<Staff> staff = new ArrayList<>();

    static {
        StaffModel.getStaff().add(new Staff("dirchev", "121212", "Dimitar Mirchev", "optician"));
        StaffModel.getStaff().add(new Staff("john", "121212", "John Cena", "receptionist"));
    }
    
    /**
     * Returns all staff members
     * @return
     */
    public static ArrayList<Staff> getStaff() {
        return staff;
    }
    
    /**
     * Finds staff member by given credentials. Usually used in authentication. Returns `null` on wrong credentials
     * @param username username to be searched for
     * @param password password to be tried for the given username.
     * @return found staff member or `null`
     */
    public static Staff findByCredentials (String username, String password) {
        for (Staff member : staff) {
            if (member.checkCredentials(username, password)) {
                return member;
            }
        }
        return null;
    }
    
}
