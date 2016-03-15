/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Helpers;

import eyeclinic.Main;
import eyeclinic.Staff;

/**
 *
 * @author dirchev
 */
public class AuthHelper {
    private static Staff loggedInUser;
    
    public static Staff getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(Staff loggedInUser) throws Exception {
        AuthHelper.loggedInUser = loggedInUser;
        Main.window.setScene(Main.scenes.get("app"));
    }
    
    public static void logOut() {
        AuthHelper.loggedInUser = null;
        Main.window.setScene(Main.scenes.get("login"));
    }
}
