/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Models;

import eyeclinic.Appointment;
import eyeclinic.Treatment;
import java.util.ArrayList;

/**
 * AppointmentsModel takes care of storing all appointments in the application while it is running.
 * @author dirchev
 */
public class AppointmentsModel {
    private static ArrayList<Appointment> appointments = new ArrayList<>();

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
}
