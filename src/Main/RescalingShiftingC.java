package Main;

import Algorithms.Part_1.BooleanOperation;
import Algorithms.Part_1.RescalingShifting;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class RescalingShiftingC {
    String imageURL = "";
    String tempURL = "";
    File imgFile;
    File tempFile;

    @FXML
    void back(MouseEvent event) {
        Controller.stage.close();
        Main.intro.show();
    }

    @FXML
    void browseImg(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png","*.png"));
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg","*.jpg"));
        imgFile = chooser.showOpenDialog(null);
        if (imgFile != null) {
            imageURL = imgFile.getAbsolutePath();
            RescalingShifting h = new RescalingShifting();
            h.rescaling(imageURL);
        }
    }
    @FXML
    void browseTemp(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png","*.png"));
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg","*.jpg"));
        tempFile = chooser.showOpenDialog(null);
        if (tempFile != null) {
            tempURL = tempFile.getAbsolutePath();
            RescalingShifting h = new RescalingShifting();
            h.shifting(tempURL);
        }
    }
}
