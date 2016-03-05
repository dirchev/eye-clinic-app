/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Stores;

import eyeclinic.Patient;
import java.util.ArrayList;

/**
 *
 * @author dirchev
 */
public class PatientsStore {
    private static ArrayList<Patient> patients = new ArrayList<>();

    static {
        PatientsStore.patients.add(new Patient("John Cena", "0123456789", "Galsgow", "john.cena@gmail.com"));
        PatientsStore.patients.add(new Patient("Dr House", "0123456780", "America!", "house@gmail.com"));
        PatientsStore.patients.add(new Patient("Dr House", "0123456780", "America!", "house@gmail.com"));
        PatientsStore.patients.add(new Patient("Dr House", "0123456780", "America!", "house@gmail.com"));
        PatientsStore.patients.add(new Patient("Dr House", "0123456780", "America!", "house@gmail.com"));
    }
    
    public static ArrayList<Patient> getPatients() {
        return patients;
    }

    public static void setPatients(ArrayList<Patient> patients) {
        PatientsStore.patients = patients;
    }
}
