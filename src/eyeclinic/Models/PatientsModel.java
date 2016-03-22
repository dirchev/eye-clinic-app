/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Models;

import eyeclinic.Patient;
import eyeclinic.Staff;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * PatientsModel takes care of storing all patients during application usage
 * @author dirchev
 */
public class PatientsModel {
    private static final ArrayList<Patient> patients = new ArrayList<>();

    static {
        loadData();
    }
    
    /**
     * Returns all patients in the system
     * @return all patients
     */
    public static ArrayList<Patient> getPatients() {
        return patients;
    }
    
    /**
     * Saves all patients in file storage
     */
    public static void saveData () {
        try (FileOutputStream fs = new FileOutputStream("patients.data")) {
            ObjectOutputStream os = new ObjectOutputStream(fs);
            
            for (Patient patient: patients) {
                os.writeObject(patient);
            }
            
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(PatientsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void loadData () {
        try(FileInputStream fi = new FileInputStream("patients.data"); ObjectInputStream os = new ObjectInputStream(fi)) { 
            // fi.available() is not the best way to check weather there are more records in the file
            // however, that is the fastest way to coop with this problem
            // the better solution is here: http://stackoverflow.com/a/2626193
            while (fi.available() > 0) {
                patients.add((Patient)os.readObject());
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PatientsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns only patients, whom name contain the given string. Not case-sensitive!
     * @param searchText text, which to be used in the filtering
     * @return list of patients, whom name contain the given string
     */
    public static ArrayList<Patient> searchByName(String searchText) {
        ArrayList<Patient> foundPatients = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getFullName().toLowerCase().contains(searchText.toLowerCase())) {
                foundPatients.add(p);
            } else {
                System.out.println(p.getFullName().toLowerCase());
                System.out.println(searchText);
            }
        }
        return foundPatients;
    }
}
