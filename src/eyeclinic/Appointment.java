package eyeclinic;

import eyeclinic.Models.PatientsModel;
import eyeclinic.Models.StaffModel;
import eyeclinic.Models.TreatmentsModel;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

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
    private final UUID id;
    private final UUID patientId;
    private final UUID treatmentId;
    private UUID opticianId;
    private Date startDate;
    private Date endDate;
    
    /**
     * Creates new appointment record.
     * @param treatment the treatment the this appointment is part of.
     * @param startDate the start date and time of the appointment
     * @param endDate the end date and time of the appointment
     */
    public Appointment (Treatment treatment, Date startDate, Date endDate) {
        this.id = UUID.randomUUID();
        this.patientId = treatment.getPatient().getId();
        this.treatmentId = treatment.getId();
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    /**
     * Get appointment id
     * @return id
     */
    public UUID getId() {
        return this.id;
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
        return PatientsModel.getById(this.patientId);
    }

    /**
     * Returns the treatment this appointment is part of
     * @return the associated treatment
     */
    public Treatment getTreatment() {
        return TreatmentsModel.getById(this.treatmentId);
    }

    /**
     * Returns the assigned optician. If no optician is assigned to this appointment `null` is returned
     * @return assigned optician
     */
    public Staff getOptician() {
        return StaffModel.getById(opticianId);
    }

    /**
     * Assigns / Updates the optician, responsible for this appointment
     * @param optician optician to be assigned to the appointment
     */
    public void setOptician (Staff optician) {
        this.opticianId = optician.getId();
    }
    
}
