package eyeclinic.UIComponents.AppointmentItem;

import eyeclinic.Appointment;
import eyeclinic.Helpers.ModalsHelper;
import eyeclinic.Pages.AppointmentPreview.AppointmentPreview;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author dirchev
 */
public class AppointmentItem extends VBox {

    private final Appointment appointment;
    public Label appointmentLabel;
    public Label timeLabel;
    public Label opticianNameLabel;
    
    
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
        appointmentLabel.setText("Appointment on " + appointment.getStartDate().getMonth().toString() + " " + appointment.getStartDate().getDayOfMonth());
        timeLabel.setText(appointment.getStartDate().getHour()+ ":" + appointment.getStartDate().getMinute() + " - " + appointment.getEndDate().getHour()+ ":" + appointment.getEndDate().getMinute());
        if (this.appointment.getOptician() != null) {
            opticianNameLabel.setText(this.appointment.getOptician().getFullName());
        }
    }
    
    public void previewAppointment () {
        ModalsHelper.showModal(new Scene(new AppointmentPreview(appointment)), false);
    }
    
}
