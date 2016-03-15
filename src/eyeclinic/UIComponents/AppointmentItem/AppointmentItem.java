/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.UIComponents.AppointmentItem;

import eyeclinic.Appointment;
import eyeclinic.Pages.PatientPreview.PatientPreview;
import eyeclinic.Stores.ModalsStore;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dirchev
 */
public class AppointmentItem extends VBox {

    private final Appointment appointment;
    public Label appointmentLabel;
    public Label timeLabel;
    
    
    public AppointmentItem (Appointment appointment) {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AppointmentItemView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.appointment = appointment;
        appointmentLabel.setText("Appointment on " + appointment.getStartDate().getDate() + " / " + appointment.getStartDate().getMonth());
        timeLabel.setText(appointment.getStartDate().getHours()+ ":" + appointment.getStartDate().getMinutes() + " - " + appointment.getEndDate().getHours()+ ":" + appointment.getEndDate().getMinutes());
    }
    
    public void previewAppointment () {
//        Scene modalContent = new Scene(new AppointmentPreview(appointment));
//        
//        Stage modal = new Stage();
//        
//        // Keep a reference to currently opened modal
//        ModalsStore.setOpenedModal(modal);
//
//        //Block events to other modals
//        modal.initModality(Modality.APPLICATION_MODAL);
//        modal.setTitle("Appointment Preview");
//        modal.setMinWidth(250);
//
//        //Display modal and wait for it to be closed before returning
//        modal.setScene(modalContent);
//        modal.showAndWait();
    }
    
}
