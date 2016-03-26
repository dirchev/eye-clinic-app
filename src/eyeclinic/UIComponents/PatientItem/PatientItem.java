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
        ModalsHelper.showModal(new Scene(new PatientPreview(patient)), false);
    }
}