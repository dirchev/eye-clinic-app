/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.UIComponents.ErrorPopOver;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.controlsfx.control.PopOver;

/**
 *
 * @author dirchev
 */
public class ErrorPopOver {
    public static void show (ArrayList<String> errors, Node node) {
        VBox container = new VBox();
        for (String err : errors) {
            container.getChildren().add(new Label(err));
        }
        container.setAlignment(Pos.CENTER);
        PopOver popOver = new PopOver();
        popOver.setContentNode(container);
        popOver.setDetachable(false);
        popOver.show(node);
    }
    public static void show (String error, Node node) {
        PopOver popOver = new PopOver();
        popOver.setContentNode(new Label(error));
        popOver.setDetachable(false);
        popOver.show(node);
    }
}
