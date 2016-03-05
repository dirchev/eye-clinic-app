/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Components.TreatmentItem;

import eyeclinic.Patient;
import eyeclinic.Treatment;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dirchev
 */
public class TreatmentItem extends VBox {
    public Label treatmentTitleLabel;
    
    private Treatment treatment;

    public TreatmentItem(Treatment treatment) {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TreatmentItemView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.treatment = treatment;
        
        // set the title label to patient's name
        treatmentTitleLabel.setText(treatment.getTitle());
    }
    
    public void previewTreatment () {
//        Scene modalContent = new Scene(new PatientPreview(patient));
//        
//        Stage modal = new Stage();
//        
//        // Keep a reference to currently opened modal
//        ModalsStore.setOpenedModal(modal);
//
//        //Block events to other modals
//        modal.initModality(Modality.APPLICATION_MODAL);
//        modal.setTitle("Patient Preview");
//        modal.setMinWidth(250);
//
//        //Display modal and wait for it to be closed before returning
//        modal.setScene(modalContent);
//        modal.showAndWait();
    }
}