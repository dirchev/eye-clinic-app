/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Modals.PatientForm;

import eyeclinic.Patient;
import eyeclinic.Stores.ModalsStore;
import eyeclinic.Stores.PatientsStore;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML PatientForm class
 *
 * @author dirchev
 */
public class PatientForm extends BorderPane {

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
    }
    
    public void handleSubmit () {
        if (this.patient == null) {
            // patient was not imported, create a new one
            this.createPatient();
        } else {
            this.updatePatient();
        }
        ModalsStore.closeModal();
    }
    
    private void createPatient () {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        PatientsStore.getPatients().add(new Patient(name, phone, address, email));
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
        ModalsStore.closeModal();
    }
    
}
