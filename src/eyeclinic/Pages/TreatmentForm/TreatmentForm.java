/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Modals.TreatmentForm;

import eyeclinic.Modals.PatientPreview.PatientPreview;
import eyeclinic.Patient;
import eyeclinic.Stores.ModalsStore;
import eyeclinic.Stores.PatientsStore;
import eyeclinic.Stores.TreatmentsStore;
import eyeclinic.Treatment;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML PatientForm class
 *
 * @author dirchev
 */
public class TreatmentForm extends BorderPane {

    public TextField titleField;
    public Label patientNameLabel;
    public Label patientEmailLabel;
    public Button cancelButton, createButton;
    
    private Patient patient = null;
    private Treatment treatment = null;
    
    // Treatment Create (only patient object is passed)
    public TreatmentForm(Patient patient) {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TreatmentFormView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.patient = patient;
        displayPatientInfo();
    }
    // Treatment Edit
    public TreatmentForm(Treatment treatment) {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TreatmentFormView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.patient = treatment.getPatient();
        this.treatment = treatment;
        titleField.setText(treatment.getTitle());
        displayPatientInfo();
    }
    
    private void displayPatientInfo () {
        patientNameLabel.setText(this.patient.getFullName());
        patientEmailLabel.setText(this.patient.getEmail());
    }
    
    public void handleSubmit () {
        if (this.treatment == null) {
            // treatment was not imported, create a new one
            this.createTreatment();
        } else {
            this.updateTreatment();
        }
        ModalsStore.showModal(new Scene(new PatientPreview(this.patient)), false);
    }
    
    private void createTreatment () {
        String title = titleField.getText();
        this.treatment = new Treatment(title, this.patient);
        TreatmentsStore.getTreatments().add(this.treatment);
    }
    
    private void updateTreatment () {
        this.treatment.setTitle(titleField.getText());
    }
    
    public void cancelCreation () {
        // TODO show alert (Are you sure you cant to cancel patient creation?)
        // TODO check for alert result
        if (this.treatment == null) {
            // close the modal
            ModalsStore.closeModal();
        } else {
            System.out.println("To be implemented");
//            ModalsStore.showModal(new Scene(new TreatmentPreview(this.treatment)), false);
        }
        
    }
    
}
