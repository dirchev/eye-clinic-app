/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic;

/**
 * Note object. Contains an additional information about eye clinic record. 
 * <p>
 * Can be used as a field of different object in the application such as Patient, Appointment or Treatment.
 * @author dirchev
 */
public class Note {
    private String id;
    private final Staff creator;
    private String content;
    
    /**
     * Creates a note
     * @param creator The creator of the note 
     * @param content Note content
     */
    public Note (Staff creator, String content) {
        this.creator = creator;
        this.content = content;
    }

    /**
     * Returns a Staff object of the creator of the note
     * @return the creator of the note
     */
    public Staff getCreator() {
        return creator;
    }
    
    /**
     * Returns a String object with the note content
     * @return the note content
     */
    public String getContent() {
        return content;
    }

    /**
     * Updates the note content
     * @param content updated note content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
