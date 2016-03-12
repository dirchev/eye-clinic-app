/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic;

import java.util.Date;

/**
 *
 * @author dirchev
 */
public class Appointment {
    private Date startDate;
    private Date endDate;
    private Patient patient;
    private Treatment treatment;
    private Staff optician;
    
    public Appointment (Treatment treatment, Date startDate, Date endDate) {
        this.patient = treatment.getPatient();
        this.treatment = treatment;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }   

    public Patient getPatient() {
        return patient;
    }

    public Treatment getTreatment() {
        return treatment;
    }
    public Staff getOptician() {
        return optician;
    }

    public void setOptician (Staff optician) {
        this.optician = optician;
    }
    
}
