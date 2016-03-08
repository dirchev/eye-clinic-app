/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Modals.TreatmentPreview;

import eyeclinic.Modals.PatientPreview.PatientPreview;
import eyeclinic.Modals.TreatmentForm.TreatmentForm;
import eyeclinic.Stores.ModalsStore;
import eyeclinic.Treatment;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML PatientPreview class
 *
 * @author dirchev
 */
public class TreatmentPreview extends VBox {
    public Label treatmentTitleLabel;
    public Label patientNameLabel;
    
    private Treatment treatment;
    
    public TreatmentPreview (Treatment treatment) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TreatmentPreviewView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.treatment = treatment;
        patientNameLabel.setText(treatment.getPatient().getFullName());
        treatmentTitleLabel.setText(treatment.getTitle());
    }
    
    public void editTreatment () {
        ModalsStore.showModal(new Scene(new TreatmentForm(this.treatment)), false);
    }
    
    public void close () {
        ModalsStore.closeModal();
    }
    
    public void viewPatient () {
        ModalsStore.showModal(new Scene(new PatientPreview(this.treatment.getPatient())), false);
    }

//    private void updateTreatmentsList() {
//        treatmentsContainer.getChildren().clear();
//        for (Treatment treatment : TreatmentsStore.getTreatmentsForPatient(this.patient)) {
//            treatmentsContainer.getChildren().add(new TreatmentItem(treatment));
//        }
//    }
}
