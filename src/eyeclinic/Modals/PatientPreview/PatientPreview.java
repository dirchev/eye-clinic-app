/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Modals.PatientPreview;

import eyeclinic.Modals.PatientForm.PatientForm;
import eyeclinic.Patient;
import eyeclinic.Stores.ModalsStore;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML PatientPreview class
 *
 * @author dirchev
 */
public class PatientPreview extends VBox {
    public Label patientNameLabel;
    
    private Patient patient;
    
    public PatientPreview (Patient patient) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PatientPreviewView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.patient = patient;
        patientNameLabel.setText(patient.getFullName());
    }
    
    public void editPatient () {
        ModalsStore.showModal(new Scene(new PatientForm(patient)));
    }
}
