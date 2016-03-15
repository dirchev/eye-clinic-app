/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.AppointmentForm;

import eyeclinic.Appointment;
import eyeclinic.Pages.TreatmentPreview.TreatmentPreview;
import eyeclinic.Patient;
import eyeclinic.Stores.AppointmentsStore;
import eyeclinic.Stores.ModalsStore;
import eyeclinic.Treatment;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 * FXML PatientForm class
 *
 * @author dirchev
 */
public class AppointmentForm extends BorderPane {

    public Label patientNameLabel, patientEmailLabel, treatmentTitleLabel, treatmentStatusLabel;
    
    public DatePicker dateField;
    public TextField startTimeMinuteField, startTimeHourField, endTimeMinuteField, endTimeHourField;
    
    public Button cancelButton, createButton;
    
    private Appointment appointment = null;
    private Treatment treatment = null;
    private Patient patient = null;
    
    // Patient Create (no patient object is passed)
    public AppointmentForm(Treatment treatment) {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AppointmentFormView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.treatment = treatment;
        this.patient = treatment.getPatient();
        this.setLabels();
    }
    // Patient Edit
    public AppointmentForm(Appointment appointment) {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AppointmentFormView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.appointment = appointment;
        this.treatment = appointment.getTreatment();
        this.patient = appointment.getPatient();
        this.setLabels();
    }
    

    private void setLabels() {
        patientNameLabel.setText(this.patient.getFullName());
        patientEmailLabel.setText(this.patient.getEmail());
        treatmentTitleLabel.setText(this.treatment.getTitle());
        treatmentStatusLabel.setText(this.treatment.getStatus());
    }
    
    private HashMap<String, Date> getDates() {
        // parse start and end date
        LocalDate date = dateField.getValue();
        Date startDate = new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), Integer.parseInt(startTimeHourField.getText()), Integer.parseInt(startTimeMinuteField.getText()));
        Date endDate = new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), Integer.parseInt(endTimeHourField.getText()), Integer.parseInt(endTimeMinuteField.getText()));
        
        HashMap<String, Date> dates = new HashMap<>();
        dates.put("startDate", startDate);
        dates.put("endDate", endDate);
        
        return dates;
    }
    
    public void handleSubmit () {
        // TODO validate the data

        if (this.appointment == null) {
            // patient was not imported, create a new one
            this.createAppointment();
        } else {
            this.updateAppointment();
        }
//        ModalsStore.showModal(new Scene(new AppointmentPreview(this.appointment)), false);
        ModalsStore.showModal(new Scene(new TreatmentPreview(this.treatment)), false);
    }
    
    private void createAppointment () {
        HashMap<String, Date> dates = this.getDates();
        AppointmentsStore.getAppointments().add(new Appointment(this.treatment, dates.get("startDate"), dates.get("endDate")));
    }
    
    private void updateAppointment () {
        HashMap<String, Date> dates = this.getDates();
        this.appointment.setStartDate(dates.get("startDate"));
        this.appointment.setEndDate(dates.get("endDate"));
    }
    
    public void cancelCreation () {
        // TODO show alert (Are you sure you cant to cancel patient creation?)
        // TODO check for alert result
        if (this.appointment == null) {
            // close the modal
            ModalsStore.closeModal();
        } else {
//            ModalsStore.showModal(new Scene(new AppointmentPreview(this.appointment)), false);
        ModalsStore.showModal(new Scene(new TreatmentPreview(this.treatment)), false);
        }
        
    }
    
}
