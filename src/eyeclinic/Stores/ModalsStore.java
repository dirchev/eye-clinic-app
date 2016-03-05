/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.Stores;

import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author dirchev
 */
public class ModalsStore {
    private static Stage openedModal = null;

    public static void setOpenedModal(Stage openedModal) {
        ModalsStore.openedModal = openedModal;
    }
    
    public static void showModal (Scene scene) {
        ModalsStore.modalInCurrentWindow(scene);
    }
    
    public static void showModal (Scene scene, Boolean createNewWindow) {
        if (createNewWindow) {
            ModalsStore.modalInNewWindow(scene);
        } else {
            ModalsStore.modalInCurrentWindow(scene);
        }
    }
    
    public static void closeModal () {
        ModalsStore.openedModal.close();
        ModalsStore.openedModal = null;
    }

    private static void modalInCurrentWindow(Scene scene) {
        Stage modal = ModalsStore.openedModal;
        if (modal == null) {
            ModalsStore.modalInNewWindow(scene);
        } else {
            ModalsStore.openedModal.setScene(scene);
        }
    }
    
    private static void modalInNewWindow(Scene scene) {
        Stage modal = new Stage();
        
        // Keep a reference to currently opened modal
        ModalsStore.openedModal = modal;

        //Block events to other modals
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.setTitle("Something");
        modal.setMinWidth(250);

        //Display modal and wait for it to be closed before returning
        modal.setScene(scene);
        modal.showAndWait();
    }
}
