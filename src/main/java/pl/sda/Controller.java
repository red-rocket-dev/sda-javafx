package pl.sda;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;


public class Controller {
    @FXML
    public Label showMessageLabel;
    @FXML
    private Canvas canvas;
    @FXML
    private Button button;

    public void initialize() {

    }

    private void drawTriangles(int count) {
        Random random = new Random();
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        for (int i = 0; i < count; i++) {
            gc.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            double[] xPoints = {random.nextInt(600), random.nextInt(600), random.nextInt(600)};
            double[] yPoints = {random.nextInt(600), random.nextInt(600), random.nextInt(600)};
            gc.fillPolygon(xPoints, yPoints, 3);
        }
    }

    public void buttonClick(ActionEvent actionEvent) {
        Window owner = canvas.getScene().getWindow();
        TextInputDialog alert = new TextInputDialog();
        alert.setTitle("Ile trojkatow?");
        alert.setWidth(1000);
        alert.setHeight(1000);
        alert.setHeaderText(null);
        alert.setContentText("Wprowadz ilosc trojkatow");
        alert.initOwner(owner);
        final Optional<String> result = alert.showAndWait();
        result.ifPresent(res -> {
            Integer desiredCount = Integer.valueOf(res);
            drawTriangles(desiredCount);
        });


    }

    public void cleanBtnAction(ActionEvent actionEvent) {
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,600,600);
    }
}
