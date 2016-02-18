/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic;

/**
 *
 * @author dirchev
 */
public class Note {
    private String id;
    private Staff creator;
    private String content;
    
    public Note (Staff creator, String content) {
        this.creator = creator;
        this.content = content;
    }
    
    public void updateContent(String content) {
        this.content = content;
    }
}
