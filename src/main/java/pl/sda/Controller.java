package pl.sda;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Window;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;


public class Controller {
    @FXML
    public Label showMessageLabel;
    @FXML
    private Canvas canvas;
    @FXML
    private Button button;

    public void initialize() throws IOException {
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        double width = canvas.getWidth();
        double height = canvas.getHeight();
        gc.fillRect(0,0, width, height);
        //gc.setFill(Color.rgb(200, 0, 0));
        gc.setFill(Color.YELLOW);
        double ovalWidth = 200;
        double ovalHeight = 200;
        double faceStartY = height / 2 - ovalHeight / 2;
        double faceStartX = width / 2 - ovalWidth / 2;
        gc.fillOval(width/2 - ovalWidth/2, height/2 - ovalHeight/2, ovalWidth, ovalHeight);
        gc.setFill(Color.WHITE);
        gc.fillOval(faceStartX + 50, faceStartY + 50, 30, 30);
        gc.fillOval(faceStartX + 125, faceStartY + 50, 30, 30);
        gc.setFill(Color.BLACK);
        gc.fillOval(faceStartX + 55, faceStartY + 60, 10, 10);
        gc.fillOval(faceStartX + 130, faceStartY + 60, 10, 10);
        gc.setStroke(Color.rgb(200, 0, 0));
        gc.setLineWidth(4.0);
        gc.strokeArc(faceStartX + 50, faceStartY + 120, 100, 50, 180, 180, ArcType.OPEN);
    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.rgb(255, 0, 0));
        gc.setStroke(Color.BLUE);

        gc.fillRect(400,400,100,100);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);
    }

    public void buttonClick(ActionEvent actionEvent) {
        Window owner = canvas.getScene().getWindow();
        TextInputDialog alert = new TextInputDialog();
        alert.setTitle("Title");
        alert.setHeaderText(null);
        alert.setContentText("Hello world");
        alert.initOwner(owner);
        final Optional<String> result = alert.showAndWait();
        result.ifPresent(res -> System.out.println(res+"asdasd"));
    }


    public void showMessageBtnAction(ActionEvent actionEvent) {
        showMessageLabel.setText("Hello world!");
    }
}
