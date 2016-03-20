package eyeclinic.Models;

import eyeclinic.Patient;
import eyeclinic.Treatment;
import java.util.ArrayList;

/**
 * Takes care of storing all treatments in the system.
 * @author dirchev
 */
public class TreatmentsModel {
    private static final ArrayList<Treatment> treatments = new ArrayList<>();

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
    public static ArrayList<Treatment> getTreatmentsForPatient(Patient patient) {
        ArrayList<Treatment> foundTreatments = new ArrayList<>();
        for (Treatment treatment : TreatmentsModel.treatments) {
            if (treatment.getPatient().equals(patient)) {
                foundTreatments.add(treatment);
            }
        }
        return foundTreatments;
    }
}
