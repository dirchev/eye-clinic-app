package eyeclinic;

import eyeclinic.Stores.AuthStore;
import eyeclinic.Stores.ModalsStore;
import eyeclinic.Stores.StaffStore;
import java.util.HashMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dirchev
 */
public class Main extends Application {
    
    public static Stage window;
    public static HashMap<String, Scene> scenes = new HashMap<>();
    
    @Override
    public void start(Stage stage) throws Exception {
        Main.window = stage;
        initScenes();
        initModals();
        window.setScene(scenes.get("login"));
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // feel data in stores
        StaffStore.getStaff().add(new Staff("dirchev", "121212", "Dimitar Mirchev", "optician"));
        StaffStore.getStaff().add(new Staff("john", "121212", "John Cena", "receptionist"));
        
        // launch the app
        launch(args);
    }
    
    private void initScenes() throws Exception {
        scenes.put("login", new Scene(FXMLLoader.load(getClass().getResource("Pages/Login/View.fxml"))));
        scenes.put("app", new Scene(FXMLLoader.load(getClass().getResource("Pages/App/View.fxml"))));
    }
    
    private void initModals () throws Exception {
        ModalsStore.getModals().put("patientPreview", new Scene(FXMLLoader.load(getClass().getResource("Modals/PatientPreview/View.fxml"))));
        ModalsStore.getModals().put("patientCreate", new Scene(FXMLLoader.load(getClass().getResource("Modals/PatientCreate/View.fxml"))));
    }
}
