/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Modals.PatientCreate;

import eyeclinic.Stores.ModalsStore;
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

    public TextField nameField, emailField, phoneField, addressField;
    public Button cancelButton, createButton;
    
    public void createPatient () {
        // TODO get the data from the fields
        // TODO validate the data
        // TODO create new patient via PatientStore.put(new Patient(...))
    }
    
    public void cancelCreation () {
        // TODO show alert (Are you sure you cant to cancel patient creation?)
        // TODO check for alert result
        ModalsStore.closeModal();
    }
    
}
