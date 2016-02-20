/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Pages.App.PatientsList.PatientItem;

import eyeclinic.Patient;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author dirchev
 */
public class PatientItem {
    private FXMLLoader loader = new FXMLLoader(
            getClass().getResource("View.fxml")
    );
    private Patient patient;

    public PatientItem(Patient patient) {
        this.patient = patient;
    }
    
    public VBox show() throws Exception {
        VBox layout = loader.load();
        
        Controller controller = loader.<Controller>getController();
        controller.initData(patient);
        
        return layout;
    }
}
