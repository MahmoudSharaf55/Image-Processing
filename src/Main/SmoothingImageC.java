package Main;

import Algorithms.Part_1.SmoothingImage;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class SmoothingImageC {
    String imageURL = "";
    File imgFile;
    @FXML
    private JFXTextField times;

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
        if (imgFile != null && !times.getText().isEmpty()) {
            imageURL = imgFile.getAbsolutePath();
            SmoothingImage h = new SmoothingImage();
            h.smoothingImage(imageURL,Integer.valueOf(times.getText()));
        }
    }
}
