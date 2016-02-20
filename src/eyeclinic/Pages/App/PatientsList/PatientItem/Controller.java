/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.App.PatientsList.PatientItem;

import eyeclinic.Patient;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author dirchev
 */
public class Controller {

    public Label patientNameLabel;
    public Button viewPatientButton;

    void initData(Patient patient) {
        patientNameLabel.setText(patient.getFullName());
    }
    
}
