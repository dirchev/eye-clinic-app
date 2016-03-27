package eyeclinic.UIComponents.MyAppointmentsList;

import eyeclinic.Appointment;
import eyeclinic.Helpers.AuthHelper;
import eyeclinic.Models.AppointmentsModel;
import eyeclinic.UIComponents.AppointmentItem.AppointmentItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML AppointmentsList class
 *
 * @author dirchev
 */
public class MyAppointmentsList extends VBox{
    
    public VBox appointmentsContainer;
    public CheckBox showNotAssignedOnlyCheckbox;

    public MyAppointmentsList() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyAppointmentsListView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        updateAppointmentsList();
    }
    
    public final void updateAppointmentsList () {
        updateAppointmentsListContents(AppointmentsModel.getAppointmentsForOptician(AuthHelper.getLoggedInUser()));
    }
    
    private final void updateAppointmentsListContents (ArrayList<Appointment> appointments) {
        appointmentsContainer.getChildren().clear();
        
        // Sort appointments by start date
        ArrayList<Appointment> sortedAppointments = new ArrayList<>(appointments);
        Collections.sort(sortedAppointments, (Appointment a1, Appointment a2) -> a1.getStartDate().compareTo(a2.getStartDate()));
        
        if (appointments.isEmpty()) {
            Label message = new Label("No appointments found...");
            appointmentsContainer.getChildren().add(message);
        } else {
            for (Appointment appointment : sortedAppointments) {
                appointmentsContainer.getChildren().add(new AppointmentItem(appointment));
            }
        }
    }
}
