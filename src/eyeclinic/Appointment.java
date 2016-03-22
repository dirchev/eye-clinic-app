package eyeclinic;

import java.io.Serializable;
import java.util.Date;

/**
 * Implementation of Appointment interface.
 * <p>
 * Appointments present a future visit of a patient in the eye clinic.
 * <p>
 * Every appointment is a part of pre-made treatment. Every appointment record has a patient and start and end times.
 * Optician is later assigned to every appointment.
 * 
 * @author dirchev
 */
public class Appointment implements Serializable {
    private Date startDate;
    private Date endDate;
    private final Patient patient;
    private final Treatment treatment;
    private Staff optician;
    
    /**
     * Creates new appointment record.
     * @param treatment the treatment the this appointment is part of.
     * @param startDate the start date and time of the appointment
     * @param endDate the end date and time of the appointment
     */
    public Appointment (Treatment treatment, Date startDate, Date endDate) {
        this.patient = treatment.getPatient();
        this.treatment = treatment;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Returns the start date and time of the appointment
     * @return start date and time of the appointment
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Updates the start date and time of the appointment.
     * @param startDate the new start date and time of the appointment
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Returns the end date and time of the appointment
     * @return end date and time of the appointment
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Updates the end date and time of the appointment.
     * @param endDate the new end date and time of the appointment
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }   

    /**
     * Returns the patient, this appointment is for
     * @return the patients associated with the appointment
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Returns the treatment this appointment is part of
     * @return the associated treatment
     */
    public Treatment getTreatment() {
        return treatment;
    }

    /**
     * Returns the assigned optician. If no optician is assigned to this appointment `null` is returned
     * @return assigned optician
     */
    public Staff getOptician() {
        return optician;
    }

    /**
     * Assigns / Updates the optician, responsible for this appointment
     * @param optician optician to be assigned to the appointment
     */
    public void setOptician (Staff optician) {
        this.optician = optician;
    }
    
}
