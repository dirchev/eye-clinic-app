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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dirchev
 */
public class Controller implements Initializable {

    public VBox container = new VBox();
    public TextField patientSearchField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updatePatientsList();
    }
    
    public void updatePatientsList () {
        this.updatePatientsListContents(PatientsStore.getPatients());
    }
    
    public void onSearchFieldUpdate () {
        String searchText = patientSearchField.getText().trim();
        this.updatePatientsListContents(PatientsStore.searchByName(searchText));
    }
    
    private void updatePatientsListContents (ArrayList<Patient> patients) {
        container.getChildren().clear();
        if (patients.size() == 0) {
            Label message = new Label("No patients found...");
            container.getChildren().add(message); 
        } else {
            for (Patient patient : patients) {
                container.getChildren().add(new PatientItem(patient));
            }
        }
    }
    
    public void createPatientButtonHandler () {
        ModalsStore.showModal(new Scene(new PatientForm()));
        updatePatientsList();
    }
}
