/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.TreatmentForm;

import eyeclinic.Pages.TreatmentPreview.TreatmentPreview;
import eyeclinic.Patient;
import eyeclinic.Helpers.ModalsHelper;
import eyeclinic.Models.TreatmentsModel;
import eyeclinic.Treatment;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
/**
 * FXML PatientForm class
 *
 * @author dirchev
 */
public class TreatmentForm extends BorderPane {

    public ChoiceBox treatmentTitleChoiceBox;
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
        setUpTitleChoiceBox();
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
        setUpTitleChoiceBox();
        displayPatientInfo();
    }

    private void setUpTitleChoiceBox() {
        ArrayList<String> treatmentTitles = new ArrayList<>();
        treatmentTitles.add("Eye check");
        treatmentTitles.add("New glasses");
        treatmentTitles.add("Contct lenses");
        treatmentTitles.add("Eye condition management");
        
        treatmentTitleChoiceBox.getItems().addAll(treatmentTitles);
        
        if (this.treatment != null) {
            treatmentTitleChoiceBox.setValue(this.treatment.getTitle());
        }
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
        ModalsHelper.showModal(new Scene(new TreatmentPreview(this.treatment)), false);
    }
    
    private void createTreatment () {
        String title = treatmentTitleChoiceBox.getValue().toString();
        this.treatment = new Treatment(title, this.patient);
        TreatmentsModel.getTreatments().add(this.treatment);
    }
    
    private void updateTreatment () {
        this.treatment.setTitle(treatmentTitleChoiceBox.getValue().toString());
    }
    
    public void cancelCreation () {
        // TODO show alert (Are you sure you cant to cancel patient creation?)
        // TODO check for alert result
        if (this.treatment == null) {
            // close the modal
            ModalsHelper.closeModal();
        } else {
            ModalsHelper.showModal(new Scene(new TreatmentPreview(this.treatment)), false);
        }
        
    }
    
}
