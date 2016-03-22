/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Helpers;

import eyeclinic.Models.AppointmentsModel;
import eyeclinic.Models.PatientsModel;
import eyeclinic.Models.StaffModel;
import eyeclinic.Models.TreatmentsModel;

/**
 * SaveDataHelper takes care of saving all records in the appropriate files by executing the `saveData()` method for every store
 * @author dirchev
 */
public class SaveDataHelper {
    public static void saveAllData() {
        StaffModel.saveData();
        PatientsModel.saveData();
        TreatmentsModel.saveData();
        AppointmentsModel.saveData();
    }
}
