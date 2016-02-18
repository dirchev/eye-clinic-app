/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic;

import java.util.ArrayList;

/**
 *
 * @author dirchev
 */
public class Patient {
    private String id;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String email;
    private ArrayList<Note> notes;

    public Patient(String fullName, String phoneNumber, String address, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.notes = new ArrayList<>();
    }
}
