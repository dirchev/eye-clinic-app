/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.AppointmentPreview;

import eyeclinic.Appointment;
import eyeclinic.Pages.AppointmentForm.AppointmentForm;
import eyeclinic.Pages.PatientPreview.PatientPreview;
import eyeclinic.Helpers.ModalsHelper;
import eyeclinic.Pages.TreatmentPreview.TreatmentPreview;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML PatientPreview class
 *
 * @author dirchev
 */
public class AppointmentPreview extends VBox {
    
    public Label appointmentStartDateLabel;
    public Label appointmentEndDateLabel;
    public Label patientNameLabel;
    public Label treatmentTitleLabel;
    public Label treatmentStatusLabel;
    
    private Appointment appointment;
    
    public AppointmentPreview (Appointment appointment) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AppointmentPreviewView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.appointment = appointment;
        initializeLayout();
    }
    
    private void initializeLayout () {
        // appointment dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d 'at' HH:mm");
        appointmentStartDateLabel.setText(dateFormat.format(appointment.getStartDate()));
        appointmentEndDateLabel.setText(dateFormat.format(appointment.getEndDate()));
        
        // patient
        patientNameLabel.setText(appointment.getPatient().getFullName());
        
        // treatment
        treatmentTitleLabel.setText(appointment.getTreatment().getTitle());
        treatmentStatusLabel.setText(appointment.getTreatment().getStatus());
    }
    
    public void editAppointment () {
        ModalsHelper.showModal(new Scene(new AppointmentForm(this.appointment)), false);
    }
    
    public void close () {
        ModalsHelper.closeModal();
    }
    
    public void viewPatient () {
        ModalsHelper.showModal(new Scene(new PatientPreview(this.appointment.getPatient())), false);
    }
    public void viewTreatment () {
        ModalsHelper.showModal(new Scene(new TreatmentPreview(this.appointment.getTreatment())), false);
    }
}
