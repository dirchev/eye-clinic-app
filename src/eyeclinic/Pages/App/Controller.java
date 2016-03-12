/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.App;

import eyeclinic.UIComponents.AppointmentsList.AppointmentsList;
import eyeclinic.UIComponents.PatientsList.PatientsList;
import eyeclinic.Stores.AuthStore;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dirchev
 */
public class Controller {

    public Button logOutButton;
    public Button appointmentsListButton, patientsListButton;
    public VBox contentWrapper;
    
    public void logOut () {
        AuthStore.logOut();
    }
    
    public void openAppointmentsList () {
        contentWrapper.getChildren().setAll(new AppointmentsList());
    }
    public void openPatientsList () {
        contentWrapper.getChildren().setAll(new PatientsList());
    }
    
}
