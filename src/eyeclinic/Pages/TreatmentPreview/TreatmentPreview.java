/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.TreatmentPreview;

import eyeclinic.Appointment;
import eyeclinic.Pages.AppointmentForm.AppointmentForm;
import eyeclinic.Pages.PatientPreview.PatientPreview;
import eyeclinic.Pages.TreatmentForm.TreatmentForm;
import eyeclinic.Stores.AppointmentsStore;
import eyeclinic.Stores.ModalsStore;
import eyeclinic.Treatment;
import eyeclinic.UIComponents.AppointmentItem.AppointmentItem;
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
    public VBox appointmentsContainer;
    
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
        updateAppointmentsList();
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
    
    public void createAppointment () {
        ModalsStore.showModal(new Scene(new AppointmentForm(this.treatment)), false);
        updateAppointmentsList();
    }

    private void updateAppointmentsList() {
        appointmentsContainer.getChildren().clear();
        for (Appointment appointment : AppointmentsStore.getAppointmentsForTreatment(this.treatment)) {
            appointmentsContainer.getChildren().add(new AppointmentItem(appointment));
        }
    }
}
