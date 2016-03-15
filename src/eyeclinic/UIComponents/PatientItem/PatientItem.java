/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.UIComponents.PatientItem;

import eyeclinic.Pages.PatientPreview.PatientPreview;
import eyeclinic.Patient;
import eyeclinic.Helpers.ModalsHelper;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dirchev
 */
public class PatientItem extends VBox {
    public Label patientNameLabel;
    public Button viewPatientButton;
    
    private Patient patient;

    public PatientItem(Patient patient) {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PatientItemView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.patient = patient;
        
        // set the title label to patient's name
        patientNameLabel.setText(patient.getFullName());
    }
    
    public void previewPatient () {
        Scene modalContent = new Scene(new PatientPreview(patient));
        
        Stage modal = new Stage();
        
        // Keep a reference to currently opened modal
        ModalsHelper.setOpenedModal(modal);

        //Block events to other modals
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.setTitle("Patient Preview");
        modal.setMinWidth(250);

        //Display modal and wait for it to be closed before returning
        modal.setScene(modalContent);
        modal.showAndWait();
    }
}