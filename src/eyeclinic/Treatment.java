package eyeclinic;

import eyeclinic.Models.PatientsModel;
import java.io.Serializable;
import java.util.UUID;

/**
 * Implementation of Treatment interface.
 * <p>
 * Treatments are used to hold a similar appointments for a patient. 
 * <p>
 * For example if a patient wants to have an eye check, a new `eye check` treatment will be created.
 * The treatment might have 2 appointments in it: one for the eye test and another for discussing the test results with an optician.
 * 
 * @author dirchev
 */
public class Treatment implements Serializable {
    private final UUID id;
    private final UUID patientId;
    private String title;
    private String status;

    /**
     * Creates new treatment for a patient. The initial status is pending
     * @param title the title of the treatment (ex. `an eye check`)
     * @param patient the patient, which this treatment is created for
     */
    public Treatment(String title, Patient patient) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.status = "pending";
        this.patientId = patient.getId();
    }
    
    /**
     * Get treatment id
     * @return id
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Returns the title of the treatment
     * @return the title of the treatment
     */
    public String getTitle() {
        return title;
    }

    /**
     * Updates the title of the treatment
     * @param title new title to override the old one
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the status of the treatment
     * @return the status of the treatment
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the status of the treatment
     * @param status new version of the status to be updated
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the Patient object, which this treatment is for 
     * @return the Patient 
     */
    public Patient getPatient() {
        return PatientsModel.getById(this.patientId);
    }
}
