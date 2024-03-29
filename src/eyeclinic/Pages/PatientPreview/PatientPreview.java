package eyeclinic.Pages.PatientPreview;

import eyeclinic.UIComponents.TreatmentItem.TreatmentItem;
import eyeclinic.Pages.PatientForm.PatientForm;
import eyeclinic.Pages.TreatmentForm.TreatmentForm;
import eyeclinic.Patient;
import eyeclinic.Helpers.ModalsHelper;
import eyeclinic.Models.TreatmentsModel;
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
public class PatientPreview extends VBox {
    public Label patientNameLabel;
    public Label patientPhoneLabel;
    public Label patientEmailLabel;
    public Label patientAddressLabel;
    
    public VBox treatmentsContainer;
    
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
        patientEmailLabel.setText(patient.getEmail());
        patientPhoneLabel.setText(patient.getPhoneNumber());
        patientAddressLabel.setText(patient.getAddress());
        
        updateTreatmentsList();
    }
    
    public void editPatient () {
        ModalsHelper.showModal(new Scene(new PatientForm(this.patient)), false);
    }
    public void newTreatment () {
        ModalsHelper.showModal(new Scene(new TreatmentForm(this.patient)), false);
        updateTreatmentsList();
    }
    
    public void close () {
        ModalsHelper.closeModal();
    }

    private void updateTreatmentsList() {
        treatmentsContainer.getChildren().clear();
        for (Treatment treatment : TreatmentsModel.getTreatmentsForPatient(this.patient)) {
            treatmentsContainer.getChildren().add(new TreatmentItem(treatment));
        }
    }
}
