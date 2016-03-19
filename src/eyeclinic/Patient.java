package eyeclinic;

import java.util.ArrayList;

/**
 * Implementation of Patient interface.
 * <p>
 * Holds all fields, needed for a patient in the eye clinic application.
 * @author dirchev
 */
public class Patient {
    private String fullName;
    private String phoneNumber;
    private String address;
    private String email;
    private ArrayList<Note> notes;

    /**
     * Constructs a new patient.
     * @param fullName the full name of the patient including first, middle and last names
     * @param phoneNumber the phone number of the patient
     * @param address the home address of the patient
     * @param email patient's email
     */
    public Patient(String fullName, String phoneNumber, String address, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.notes = new ArrayList<>();
    }

    /**
     * Returns the full name of the patient
     * @return the full name of the patient
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Updates patient's full name
     * @param fullName updated full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Returns the phone number of the patient
     * @return the phone number of the patient
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Updates the phone number of the patient
     * @param phoneNumber the new phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the patient's address
     * @return patient's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Updates patient's address
     * @param address the new address to be updated
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns patient's email
     * @return patient's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Updates patient's email
     * @param email the new email to be updated
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
