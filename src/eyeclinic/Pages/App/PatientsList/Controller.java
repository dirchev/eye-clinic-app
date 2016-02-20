/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.App.PatientsList;

import eyeclinic.Pages.App.PatientsList.PatientItem.PatientItem;
import eyeclinic.Patient;
import eyeclinic.Stores.ModalsStore;
import eyeclinic.Stores.PatientsStore;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dirchev
 */
public class Controller implements Initializable {

    public VBox container = new VBox();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updatePatientsList();
    }
    
    private void updatePatientsList () {
        container.getChildren().clear();
        for (Patient patient : PatientsStore.getPatients()) {
            PatientItem patientItem = new PatientItem(patient);
            try {
                container.getChildren().add(patientItem.show());
            } catch (Exception e) {
                System.err.println("Error while loading patient item");
            }
        }
    }
    
    public void createPatientButtonHandler () {
        ModalsStore.showModal("patientCreate");
        updatePatientsList();
    }
}
