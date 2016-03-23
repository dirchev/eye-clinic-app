package eyeclinic.Models;

import eyeclinic.Patient;
import eyeclinic.Treatment;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Takes care of storing all treatments in the system.
 * @author dirchev
 */
public class TreatmentsModel {
    private static ArrayList<Treatment> treatments = new ArrayList<>();

    static {
        loadData();
    }
    
    /**
     * Saves all treatments in file storage
     */
    public static void saveData () {
        try (FileOutputStream fs = new FileOutputStream("treatments.data")) {
            ObjectOutputStream os = new ObjectOutputStream(fs);
            
            os.writeObject(treatments);
            
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(TreatmentsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void loadData () {
        try(FileInputStream fi = new FileInputStream("treatments.data"); ObjectInputStream os = new ObjectInputStream(fi)) { 
            treatments = (ArrayList<Treatment>)os.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PatientsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Returns all treatments in the eye clinic
     * @return all treatments in the eye clinic
     */
    public static ArrayList<Treatment> getTreatments() {
        return treatments;
    }
    
    /**
     * Returns all treatments associated with given patient
     * @param patient patient to be used in searching for treatments
     * @return all treatments for the given patient
     */
    public static ArrayList<Treatment> getTreatmentsForPatient (Patient patient) {
        ArrayList<Treatment> foundTreatments = new ArrayList<>();
        for (Treatment t : treatments) {
            if (t.getPatient().equals(patient)) {
                foundTreatments.add(t);
            }
        }
        return foundTreatments;
    }
}
