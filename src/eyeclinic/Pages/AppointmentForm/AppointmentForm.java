/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.AppointmentForm;

import eyeclinic.Appointment;
import eyeclinic.Patient;
import eyeclinic.Models.AppointmentsModel;
import eyeclinic.Helpers.ModalsHelper;
import eyeclinic.Helpers.ValidatedInput;
import eyeclinic.Pages.AppointmentPreview.AppointmentPreview;
import eyeclinic.Treatment;
import eyeclinic.UIComponents.ErrorPopOver.ErrorPopOver;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML PatientForm class
 *
 * @author dirchev
 */
public class AppointmentForm extends BorderPane {

    public Label formTitle;
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
        
        // populate fields to be ready for editing
        dateField.setValue(this.appointment.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        startTimeHourField.setText(String.valueOf(this.appointment.getStartDate().getHours()));
        startTimeMinuteField.setText(String.valueOf(this.appointment.getStartDate().getMinutes()));
        endTimeHourField.setText(String.valueOf(this.appointment.getEndDate().getHours()));
        endTimeMinuteField.setText(String.valueOf(this.appointment.getEndDate().getMinutes()));

        formTitle.setText("Edit Appointment");
        
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
        Boolean hasError = false;
        
        // validate
        LocalDate date = dateField.getValue();
        if (date == null) {
            ErrorPopOver.show("Date is required", dateField);
        }
        
        ArrayList<String> startTimeErrorMessages = new ArrayList<>();
        ArrayList<String> endTimeErrorMessages = new ArrayList<>();
        
        String startTimeHour = startTimeHourField.getText();
        ValidatedInput validatedStartTimeHour = new ValidatedInput(startTimeHour, "Hour").hour();
        if (!validatedStartTimeHour.isValid()) {
            startTimeErrorMessages.addAll(validatedStartTimeHour.getValidationMessages());
            hasError = true;
        }
        
        String endTimeHour = endTimeHourField.getText();
        ValidatedInput validatedEndTimeHour = new ValidatedInput(endTimeHour, "Hour").hour();
        if (!validatedEndTimeHour.isValid()) {
            endTimeErrorMessages.addAll(validatedEndTimeHour.getValidationMessages());
            hasError = true;
        }
        
        String startTimeMinute = startTimeMinuteField.getText();
        ValidatedInput validatedStartTimeMinute = new ValidatedInput(startTimeMinute, "Minutes").minutes();
        if (!validatedStartTimeMinute.isValid()) {
            startTimeErrorMessages.addAll(validatedStartTimeMinute.getValidationMessages());
            hasError = true;
        }
       
        String endTimeMinute = endTimeMinuteField.getText();
        ValidatedInput validatedEndTimeMinute = new ValidatedInput(endTimeMinute, "Minutes").minutes();
        if (!validatedEndTimeMinute.isValid()) {
            endTimeErrorMessages.addAll(validatedEndTimeMinute.getValidationMessages());
            hasError = true;
        }
        
        if (hasError) {
            if (startTimeErrorMessages.size() > 0) {
                ErrorPopOver.show(startTimeErrorMessages, startTimeMinuteField);
            }
            if (endTimeErrorMessages.size() > 0) {
                ErrorPopOver.show(endTimeErrorMessages, endTimeMinuteField);
            }
        } else {
            if (this.appointment == null) {
                // patient was not imported, create a new one
                this.createAppointment();
            } else {
                this.updateAppointment();
            }
            ModalsHelper.showModal(new Scene(new AppointmentPreview(this.appointment)), false);
        }
    }
    
    private void createAppointment () {
        HashMap<String, Date> dates = this.getDates();
        this.appointment = new Appointment(this.treatment, dates.get("startDate"), dates.get("endDate"));
        AppointmentsModel.getAppointments().add(this.appointment);
    }
    
    private void updateAppointment () {
        HashMap<String, Date> dates = this.getDates();
        this.appointment.setStartDate(dates.get("startDate"));
        this.appointment.setEndDate(dates.get("endDate"));
        this.appointment.setOptician(null);
    }
    
    public void cancelCreation () {
        // TODO show alert (Are you sure you cant to cancel patient creation?)
        // TODO check for alert result
        if (this.appointment == null) {
            // close the modal
            ModalsHelper.closeModal();
        } else {
            ModalsHelper.showModal(new Scene(new AppointmentPreview(this.appointment)), false);
        }
        
    }
}
