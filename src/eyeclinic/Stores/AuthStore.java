/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Stores;

import eyeclinic.Main;
import eyeclinic.Staff;

/**
 *
 * @author dirchev
 */
public class AuthStore {
    private static Staff loggedInUser;

    public static Staff getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(Staff loggedInUser) throws Exception {
        AuthStore.loggedInUser = loggedInUser;
        Main.window.setScene(Main.scenes.get("app"));
    }
    
    public static void logOut() {
        AuthStore.loggedInUser = null;
        Main.window.setScene(Main.scenes.get("login"));
    }
    
}
