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
 *
 * @author dirchev
 */
public class AppointmentsModel {
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public static void setAppointments(ArrayList<Appointment> appointments) {
        AppointmentsModel.appointments = appointments;
    }
    
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
