/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Models;

import eyeclinic.Staff;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * StaffModel takes care of storing all staff members in the system
 * @author dirchev
 */
public class StaffModel {
    private static ArrayList<Staff> staff = new ArrayList<>();

    static {
        loadData();
    }
    
    /**
     * Returns all staff members
     * @return all staff members
     */
    public static ArrayList<Staff> getStaff() {
        return staff;
    }
    /**
     * Saves all staff members in file storage
     */
    public static void saveData () {
        try (FileOutputStream fs = new FileOutputStream("staff.data"); ObjectOutputStream os = new ObjectOutputStream(fs)) {
            os.writeObject(staff);
        } catch (IOException ex) {
            Logger.getLogger(StaffModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void loadData () {
        try(FileInputStream fi = new FileInputStream("staff.data"); ObjectInputStream os = new ObjectInputStream(fi)) { 
            staff = (ArrayList<Staff>)os.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            // if no data found, add the default user
            staff.add(new Staff("admin", "121212", "Dimitar Mirchev"));
            Logger.getLogger(StaffModel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    /**
     * Find staff member by given UUID
     * @param id id to be used when searching for staff member
     * @return staff object with the given id or null if no staff member is found
     */
    public static Staff getById(UUID id) {
        for (Staff s : staff) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }
    
}
