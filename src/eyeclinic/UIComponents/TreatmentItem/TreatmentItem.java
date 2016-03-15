/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeclinic.UIComponents.TreatmentItem;

import eyeclinic.Pages.TreatmentPreview.TreatmentPreview;
import eyeclinic.Helpers.ModalsHelper;
import eyeclinic.Treatment;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dirchev
 */
public class TreatmentItem extends VBox {
    public Label treatmentTitleLabel;
    
    private Treatment treatment;

    public TreatmentItem(Treatment treatment) {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TreatmentItemView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.treatment = treatment;
        
        // set the title label to patient's name
        treatmentTitleLabel.setText(treatment.getTitle());
    }
    
    public void previewTreatment () {
        ModalsHelper.showModal(new Scene(new TreatmentPreview(this.treatment)), false);
    }
}