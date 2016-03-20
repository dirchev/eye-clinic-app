/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Models;

import eyeclinic.Patient;
import eyeclinic.Treatment;
import java.util.ArrayList;

/**
 *
 * @author dirchev
 */
public class TreatmentsModel {
    private static ArrayList<Treatment> treatments = new ArrayList<>();

    public static ArrayList<Treatment> getTreatments() {
        return treatments;
    }

    public static void setTreatments(ArrayList<Treatment> treatments) {
        TreatmentsModel.treatments = treatments;
    }
    
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
