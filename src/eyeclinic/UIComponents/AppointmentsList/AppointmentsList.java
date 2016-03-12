/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.UIComponents.AppointmentsList;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

/**
 * FXML AppointmentsList class
 *
 * @author dirchev
 */
public class AppointmentsList extends VBox{

    public AppointmentsList() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AppointmentsListView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
