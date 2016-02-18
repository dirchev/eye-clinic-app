/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dirchev
 */
public class Clinic {
    Staff loggedInUser;
    private ArrayList<Staff> staff = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();
    
    public Clinic () {
        this.init();
        this.promptLogin();
    }
    
    private void init () {
        staff.add(new Staff("dirchev", "121212", "Dimtiar Mirchev"));
        staff.add(new Staff("dirchev2", "121212", "Dimtiar Mirchev"));
        patients.add(new Patient("Dimitar Patient", "+359876511224", "Glasgow", "dimitar.mirchev96@gmail.com"));
        patients.add(new Patient("Dimitar Patient2", "+359876511225", "Glasgow", "dirchev@camplight.net"));
    }
    
    private void promptLogin () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Log in:");
        System.out.println("Username:");
        String username = sc.nextLine();
        System.out.println("Password:");
        String password = sc.nextLine();
        
        processLogin(username, password);
    }
    
    private void processLogin (String username, String password) {
        Boolean isAuthenticated = false;
        for (int i = 0 ; i < staff.size() ; i++) {
            Staff current = staff.get(i);
            if (current.checkCredentials(username, password)) {
                loggedInUser = current;
                isAuthenticated = true;
                break;
            }
        }
        if (!isAuthenticated) {
            System.out.println("Wrong username or password!");
            this.promptLogin();
        } else {
            System.out.println("Successful authentication!");
            System.out.println("Hello, " + loggedInUser.getFullName());            
        }
    }
}
