/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Helpers;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * ModalsHelper takes care of opening, updating and closing secondary windows (also called `Pop-ups` or `Modals`).
 * @author dirchev
 */
public class ModalsHelper {
    private static Stage openedModal = null;
    
    /**
     * Open a scene in secondary window.
     * @param scene the scene to be shown in the window
     * @param createNewWindow weather to create new window or use already created one if any
     */
    public static void showModal (Scene scene, Boolean createNewWindow) {
        if (createNewWindow) {
            ModalsHelper.modalInNewWindow(scene);
        } else {
            ModalsHelper.modalInCurrentWindow(scene);
        }
    }
    
    /**
     * Close secondary window
     */
    public static void closeModal () {
        ModalsHelper.openedModal.close();
        ModalsHelper.openedModal = null;
    }

    private static void modalInCurrentWindow(Scene scene) {
        Stage modal = ModalsHelper.openedModal;
        if (modal == null) {
            ModalsHelper.modalInNewWindow(scene);
        } else {
            ModalsHelper.openedModal.setScene(scene);
        }
    }
    
    private static void modalInNewWindow(Scene scene) {
        Stage modal = new Stage();
        
        // Keep a reference to currently opened modal
        ModalsHelper.openedModal = modal;

        //Block events to other modals
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.setTitle("Eye Clinic");
        modal.setMinWidth(250);

        //Display modal and wait for it to be closed before returning
        modal.setScene(scene);
        modal.setOnHiding((e) -> ModalsHelper.openedModal = null);
        modal.showAndWait();
    }
}
