/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Modals.PatientCreate;

import eyeclinic.Patient;
import eyeclinic.Stores.ModalsStore;
import eyeclinic.Stores.PatientsStore;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author dirchev
 */
public class Controller {

    public TextField nameField;
    public TextField emailField;
    public TextField phoneField;
    public TextField addressField;
    public Button cancelButton, createButton;
    
    public void createPatient () {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        // TODO validate the data

        PatientsStore.getPatients().add(new Patient(name, phone, address, email));    
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        addressField.setText("");
        ModalsStore.closeModal();
    }
    
    public void cancelCreation () {
        // TODO show alert (Are you sure you cant to cancel patient creation?)
        // TODO check for alert result
        ModalsStore.closeModal();
    }
    
}
