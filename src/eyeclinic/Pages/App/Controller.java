/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.App;

import eyeclinic.UIComponents.AppointmentsList.AppointmentsList;
import eyeclinic.UIComponents.PatientsList.PatientsList;
import eyeclinic.Helpers.AuthHelper;
import eyeclinic.Helpers.SaveDataHelper;
import eyeclinic.UIComponents.MyAppointmentsList.MyAppointmentsList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dirchev
 */
public class Controller implements Initializable {

    public Button logOutButton;
    public Button appointmentsListButton, patientsListButton;
    public VBox contentWrapper;
    public HBox navigationContainer;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String role = AuthHelper.getLoggedInUser().getRole();
        if (role.equals("optician")) {
            navigationContainer.getChildren().remove(0);
            this.openMyAppointmentsList();
        } else if (role.equals("receptionist")) {
            navigationContainer.getChildren().remove(1);
            this.openAppointmentsList();
        }
    }
    
    public void logOut () {
        AuthHelper.logOut();
    }
    
    public void saveData () {
        SaveDataHelper.saveAllData();
    }
    
    public void openAppointmentsList () {
        contentWrapper.getChildren().setAll(new AppointmentsList());
    }
    public void openMyAppointmentsList () {
        contentWrapper.getChildren().setAll(new MyAppointmentsList());
    }
    public void openPatientsList () {
        contentWrapper.getChildren().setAll(new PatientsList());
    }
    
}
