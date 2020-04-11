package Main;

import Algorithms.Part_2.HistogramEqualization;
import Algorithms.Part_2.Threshold;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class thresholdController {
    String imageURL = "";
    File imgFile;

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
            Threshold h = new Threshold();
            h.adaptativeThresholding(imageURL);
        }
    }
}
