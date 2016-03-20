/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Models;

import eyeclinic.Staff;
import java.util.ArrayList;

/**
 *
 * @author dirchev
 */
public class StaffModel {
    private static ArrayList<Staff> staff = new ArrayList<>();

    static {
        StaffModel.getStaff().add(new Staff("dirchev", "121212", "Dimitar Mirchev", "optician"));
        StaffModel.getStaff().add(new Staff("john", "121212", "John Cena", "receptionist"));
    }
    
    public static ArrayList<Staff> getStaff() {
        return staff;
    }

    public static void setStaff(ArrayList<Staff> staff) {
        StaffModel.staff = staff;
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
