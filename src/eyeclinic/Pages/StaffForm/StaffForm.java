/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.StaffForm;

import eyeclinic.Helpers.ModalsHelper;
import eyeclinic.Models.StaffModel;
import eyeclinic.Staff;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML StaffForm class
 *
 * @author dirchev
 */
public class StaffForm extends BorderPane {

    public TextField usernameField;
    public TextField passwordField;
    public TextField nameField;
    public ChoiceBox<String> roleChoiceBox;
    public Button cancelButton, createButton;
    
    private Staff staff = null;
    
    // Patient Create (no patient object is passed)
    public StaffForm() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StaffFormView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        ArrayList<String> staffRoles = new ArrayList<>();
        staffRoles.add("optician");
        staffRoles.add("receptionist");
        roleChoiceBox.getItems().addAll(staffRoles);
        roleChoiceBox.setValue("optician");
    }
    
    public void handleSubmit () {
        this.createStaff();
        ModalsHelper.closeModal();
    }
    
    private void createStaff () {
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String role = roleChoiceBox.getValue();
        this.staff = new Staff(username, password, name, role);
        StaffModel.getStaff().add(this.staff);
    }

    public void cancelCreation () {
        ModalsHelper.closeModal();
    }
    
}
