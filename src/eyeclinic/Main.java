package eyeclinic;

import java.util.HashMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
        window.setScene(scenes.get("login"));
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // launch the app
        launch(args);
    }
    
    private void initScenes() throws Exception {
        scenes.put("login", new Scene(FXMLLoader.load(getClass().getResource("Pages/Login/View.fxml"))));
        scenes.put("app", new Scene(FXMLLoader.load(getClass().getResource("Pages/App/View.fxml"))));
    }
}
