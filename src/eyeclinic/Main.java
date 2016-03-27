package eyeclinic;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The start point of the eye clinic application. Initialises the window object and starts the GUI.
 * @author dirchev
 */
public class Main extends Application {
    
    /**
     * The base Stage of the application
     */
    public static Stage window;
    
    @Override
    public void start(Stage stage) throws Exception {
        Main.window = stage;
        window.setScene(this.getScene("login"));
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // launch the app
        launch(args);
    }
    
    /**
     * Returns a scene instance based on page name
     * @param page name of the page (currently "login" or "app")
     * @return scene instance
     */
    public static Scene getScene (String page){
        Scene scene = null;
        if(page.equals("login")) {
            try {
                scene = new Scene(FXMLLoader.load(Main.class.getResource("Pages/Login/View.fxml")));
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                scene = new Scene(FXMLLoader.load(Main.class.getResource("Pages/App/View.fxml")));
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return scene;
    }
}
