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
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * StaffModel takes care of storing all staff members in the system
 * @author dirchev
 */
public class StaffModel {
    private static final ArrayList<Staff> staff = new ArrayList<>();

    static {
        loadData();
    }
    
    /**
     * Returns all staff members
     * @return
     */
    public static ArrayList<Staff> getStaff() {
        return staff;
    }
    
    public static void saveData () {
        try (FileOutputStream fs = new FileOutputStream("staff.data")) {
            ObjectOutputStream os = new ObjectOutputStream(fs);
            
            for (Staff member: staff) {
                os.writeObject(member);
            }
            
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(StaffModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void loadData () {
        try(FileInputStream fi = new FileInputStream("staff.data"); ObjectInputStream os = new ObjectInputStream(fi)) { 
            // fi.available() is not the best way to check weather there are more records in the file
            // however, that is the fastest way to coop with this problem
            // the better solution is here: http://stackoverflow.com/a/2626193
            while (fi.available() > 0) {
                staff.add((Staff)os.readObject());
            }
        } catch (IOException | ClassNotFoundException ex) {
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
    
}
