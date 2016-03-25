package eyeclinic.Models;

import eyeclinic.Appointment;
import eyeclinic.Treatment;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * AppointmentsModel takes care of storing all appointments in the application while it is running.
 * @author dirchev
 */
public class AppointmentsModel {
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    static {
        loadData();
    }
    
    /**
     * Saves all patients in file storage
     */
    public static void saveData () {
        try (FileOutputStream fs = new FileOutputStream("appointments.data")) {
            ObjectOutputStream os = new ObjectOutputStream(fs);
                
            os.writeObject(appointments);
            
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(PatientsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void loadData () {
        try(FileInputStream fi = new FileInputStream("appointments.data"); ObjectInputStream os = new ObjectInputStream(fi)) {
            appointments = (ArrayList<Appointment>)os.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PatientsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Returns all appointments in the system.
     * @return all stored appointments
     */
    public static ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Returns all appointments associated with a given treatment.
     * @param treatment the treatment based on which the appointments will be filtered
     * @return all appointments associated with the given treatment
     */
    public static ArrayList<Appointment> getAppointmentsForTreatment (Treatment treatment) {
        ArrayList<Appointment> foundAppointments = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getTreatment().equals(treatment)) {
                foundAppointments.add(a);
            }
        }
        return foundAppointments;
    }
    
    /**
     * Find appointment by given UUID
     * @param id id to be used when searching for appointment
     * @return appointment with the given id or null if no appointment is found
     */
    public static Appointment getById (UUID id) {
        for (Appointment a : appointments) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }
}
