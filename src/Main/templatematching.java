package Main;

import Algorithms.Part_2.HistogramEqualization;
import Algorithms.Part_3.TemplateMatching;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class templatematching {
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
        if (imgFile != null && tempFile != null) {
            imageURL = imgFile.getAbsolutePath();
            tempURL = tempFile.getAbsolutePath();
            TemplateMatching h = new TemplateMatching();
            h.templateMatching(imageURL,tempURL);
        }
    }
    @FXML
    void browseTemp(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png","*.png"));
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg","*.jpg"));
        tempFile = chooser.showOpenDialog(null);
        if (imgFile != null && tempFile != null) {
            imageURL = imgFile.getAbsolutePath();
            tempURL = tempFile.getAbsolutePath();
            TemplateMatching h = new TemplateMatching();
            h.templateMatching(imageURL,tempURL);
        }
    }
}
