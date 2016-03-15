/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.UIComponents.PatientsList;

import eyeclinic.UIComponents.PatientItem.PatientItem;
import eyeclinic.Pages.PatientForm.PatientForm;
import eyeclinic.Patient;
import eyeclinic.Helpers.ModalsHelper;
import eyeclinic.Stores.PatientsStore;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML PatientsList class
 *
 * @author dirchev
 */
public class PatientsList extends VBox {

    public VBox container = new VBox();
    public TextField patientSearchField;
    
    public PatientsList() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PatientsListView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
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
        if (patients.isEmpty()) {
            Label message = new Label("No patients found...");
            container.getChildren().add(message); 
        } else {
            for (Patient patient : patients) {
                container.getChildren().add(new PatientItem(patient));
            }
        }
    }
    
    public void createPatientButtonHandler () {
        ModalsHelper.showModal(new Scene(new PatientForm()));
        updatePatientsList();
    }
}
