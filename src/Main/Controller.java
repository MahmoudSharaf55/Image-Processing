package Main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Controller {
    static Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    void appClose(MouseEvent event) {
        Platform.exit();
    }
    @FXML
    void HistogramEqualization(ActionEvent event) {
        openStage("HistogramEqualization.fxml");
    }

    @FXML
    void LoadDisplayImage(ActionEvent event) {
        openStage("LoadDisplay.fxml");
    }

    @FXML
    void PointProcessing(ActionEvent event) {
        openStage("point.fxml");
    }

    @FXML
    void RescalingShifting(ActionEvent event) {
        openStage("RescalingShifting.fxml");
    }

    @FXML
    void SmoothingImage(ActionEvent event) {
        openStage("SmoothingImage.fxml");
    }

    @FXML
    void StaticFilter(ActionEvent event) {
        openStage("StaticFilter.fxml");
    }

    @FXML
    void TemplateMatching(ActionEvent event) {
        openStage("template.fxml");
    }

    @FXML
    void Threshold(ActionEvent event) {
        openStage("threshold.fxml");
    }

    @FXML
    void booleanOperation(ActionEvent event) {
        openStage("boolean.fxml");
    }

    @FXML
    void edgeDetection(ActionEvent event) {
        openStage("EdgeDetection.fxml");
    }
    void openStage(String name){
        Main.intro.close();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });
        primaryStage.setTitle("Image Processing");
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        stage = primaryStage;
    }
}
