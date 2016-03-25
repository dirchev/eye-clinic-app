/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.Login;

import eyeclinic.Staff;
import eyeclinic.Helpers.AuthHelper;
import eyeclinic.Helpers.ModalsHelper;
import eyeclinic.Models.StaffModel;
import eyeclinic.Pages.StaffForm.StaffForm;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author dirchev
 */
public class Controller {
    public Button loginButton;
    public TextField usernameTextField, passwordTextField;
    public VBox layout;
    
    public void handleLoginButtonSubmit () throws Exception {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        
        Staff user = StaffModel.findByCredentials(username, password);
        if (user != null) {
            AuthHelper.setLoggedInUser(user);
        } else {
            Label errorMessageLabel = new Label("Wrong username or password");
            errorMessageLabel.setTextFill(Paint.valueOf("#FF0000"));
            layout.getChildren().add(1, errorMessageLabel);
        }
    }
    
    public void handleSugnUpButton () {
        ModalsHelper.showModal(new Scene(new StaffForm()), true);
    }
}
