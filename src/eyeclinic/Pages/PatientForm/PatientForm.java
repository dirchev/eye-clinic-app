/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.PatientForm;

import eyeclinic.Pages.PatientPreview.PatientPreview;
import eyeclinic.Patient;
import eyeclinic.Helpers.ModalsHelper;
import eyeclinic.Helpers.ValidatedInput;
import eyeclinic.Models.PatientsModel;
import eyeclinic.UIComponents.ErrorPopOver.ErrorPopOver;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML PatientForm class
 *
 * @author dirchev
 */
public class PatientForm extends BorderPane {

    public Label formTitle;
    public TextField nameField;
    public TextField emailField;
    public TextField phoneField;
    public TextField addressField;
    public Button cancelButton, createButton;
    
    private Patient patient = null;
    
    // Patient Create (no patient object is passed)
    public PatientForm() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PatientFormView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    // Patient Edit
    public PatientForm(Patient patient) {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PatientFormView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.patient = patient;
        nameField.setText(patient.getFullName());
        emailField.setText(patient.getEmail());
        phoneField.setText(patient.getPhoneNumber());
        addressField.setText(patient.getAddress());
        
        formTitle.setText("Edit Patient");
    }
    
    public void handleSubmit () {
        Boolean hasError = false;
        
        String name = nameField.getText();
        ValidatedInput validatedName = new ValidatedInput(name, "Name").min_length(3).max_length(40).alphaSpace();
        if (!validatedName.isValid()) {
            ErrorPopOver.show(validatedName.getValidationMessages(), nameField);
            hasError = true;
        }
        
        String email = emailField.getText();
        ValidatedInput validatedEmail = new ValidatedInput(email, "Email").email();
        if (!validatedEmail.isValid()) {
            ErrorPopOver.show(validatedEmail.getValidationMessages(), emailField);
            hasError = true;
        }
        
        String phone = phoneField.getText();
        ValidatedInput validatedPhone = new ValidatedInput(phone, "Phone").phone();
        if (!validatedPhone.isValid()) {
            ErrorPopOver.show(validatedPhone.getValidationMessages(), phoneField);
            hasError = true;
        }
        
        String address = addressField.getText();
        ValidatedInput validatedAddress = new ValidatedInput(address, "Address").min_length(3);
        if (!validatedAddress.isValid()) {
            ErrorPopOver.show(validatedAddress.getValidationMessages(), addressField);
            hasError = true;
        }
        
        if (!hasError) {
            if (this.patient == null) {
                // patient was not imported, create a new one
                this.createPatient();
            } else {
                this.updatePatient();
            }
            ModalsHelper.showModal(new Scene(new PatientPreview(this.patient)), false);
        }
        
    }
    
    private void createPatient () {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        this.patient = new Patient(name, phone, address, email);
        PatientsModel.getPatients().add(this.patient);
    }
    
    private void updatePatient () {
        this.patient.setFullName(nameField.getText());
        this.patient.setEmail(emailField.getText());
        this.patient.setPhoneNumber(phoneField.getText());
        this.patient.setAddress(addressField.getText());
    }
    
    public void cancelCreation () {
        // TODO show alert (Are you sure you cant to cancel patient creation?)
        // TODO check for alert result
        if (this.patient == null) {
            // close the modal
            ModalsHelper.closeModal();
        } else {
            ModalsHelper.showModal(new Scene(new PatientPreview(this.patient)), false);
        }
        
    }
    
}
