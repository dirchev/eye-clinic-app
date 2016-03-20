/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Models;

import eyeclinic.Patient;
import java.util.ArrayList;

/**
 *
 * @author dirchev
 */
public class PatientsModel {
    private static ArrayList<Patient> patients = new ArrayList<>();

    static {
        PatientsModel.patients.add(new Patient("John Cena", "0123456789", "Galsgow", "john.cena@gmail.com"));
        PatientsModel.patients.add(new Patient("Dr House", "0123456780", "America!", "house@gmail.com"));
        PatientsModel.patients.add(new Patient("Dr School", "0123456780", "America!", "house@gmail.com"));
        PatientsModel.patients.add(new Patient("Dr Room", "0123456780", "America!", "house@gmail.com"));
        PatientsModel.patients.add(new Patient("Dr Something", "0123456780", "America!", "house@gmail.com"));
    }
    
    public static ArrayList<Patient> getPatients() {
        return patients;
    }

    public static void setPatients(ArrayList<Patient> patients) {
        PatientsModel.patients = patients;
    }

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
