/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Helpers;

import eyeclinic.Main;
import eyeclinic.Staff;

/**
 * AuthHelper is used to store the logged in user.
 * @author dirchev
 */
public class AuthHelper {
    private static Staff loggedInUser;
    
    /**
     * Returns the logged in user. If no user is logged in, returns `null`.
     * @return the logged in user
     */
    public static Staff getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Updates the logged in user. The application scene is changed from login to `app`.
     * @param loggedInUser Staff object to be saved as logged in user
     * @throws Exception
     */
    public static void setLoggedInUser(Staff loggedInUser) throws Exception {
        AuthHelper.loggedInUser = loggedInUser;
        Main.window.setScene(Main.getScene("app"));
    }
    
    /**
     *
     */
    public static void logOut() {
        AuthHelper.loggedInUser = null;
        Main.window.setScene(Main.getScene("login"));
    }
}
