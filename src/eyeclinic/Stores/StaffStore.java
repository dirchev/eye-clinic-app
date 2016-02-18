/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Stores;

import eyeclinic.Staff;
import java.util.ArrayList;

/**
 *
 * @author dirchev
 */
public class StaffStore {
    private static ArrayList<Staff> staff = new ArrayList<>();

    public static ArrayList<Staff> getStaff() {
        return staff;
    }

    public static void setStaff(ArrayList<Staff> staff) {
        StaffStore.staff = staff;
    }
    
    public static Staff findByCredentials (String username, String password) {
        for (Staff member : staff) {
            if (member.checkCredentials(username, password)) {
                return member;
            }
        }
        return null;
    }
    
}
