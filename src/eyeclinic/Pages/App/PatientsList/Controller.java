/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.App.PatientsList;

import eyeclinic.Components.PatientItem.PatientItem;
import eyeclinic.Modals.PatientForm.PatientForm;
import eyeclinic.Patient;
import eyeclinic.Stores.ModalsStore;
import eyeclinic.Stores.PatientsStore;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
            container.getChildren().add(new PatientItem(patient));
        }
    }
    
    public void createPatientButtonHandler () {
        ModalsStore.showModal(new Scene(new PatientForm()));
        updatePatientsList();
    }
}
