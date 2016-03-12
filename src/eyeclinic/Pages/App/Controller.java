/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.App;

import eyeclinic.Main;
import eyeclinic.Stores.AuthStore;
import eyeclinic.Stores.ModalsStore;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dirchev
 */
public class Controller implements Initializable {

    private HashMap<String, VBox> contentLayouts = new HashMap<>();
    public Button logOutButton;
    public Button appointmentsListButton, patientsListButton;
    public VBox contentWrapper;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            initLayouts();
        } catch (Exception e) {
            System.out.println("Error while loading app layouts and modals");
            System.err.println(e);
        }
    }
    
    public void logOut () {
        AuthStore.logOut();
    }
    
    public void openAppointmentsList () {
        changeContent("appointmentsList");
    }
    public void openPatientsList () {
        changeContent("patientsList");
    }
    
    private void initLayouts () throws Exception {
        contentLayouts.put("appointmentsList", FXMLLoader.load(getClass().getResource("AppointmentsList/AppointmentsListView.fxml")));
        contentLayouts.put("patientsList", FXMLLoader.load(getClass().getResource("PatientsList/PatientsListView.fxml")));
    }
    
    private void changeContent (String name) {
        contentWrapper.getChildren().setAll(contentLayouts.get(name));
    }
    
}
