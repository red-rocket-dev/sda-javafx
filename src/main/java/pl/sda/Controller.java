package pl.sda;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Window;

import java.util.Optional;


public class Controller {

    @FXML
    private Canvas canvas;
    @FXML
    private Button button;

    public void initialize() {
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.GREEN);
        gc.fillRect(50,20,100,200);
        gc.fillOval(160,20,100,200);
        gc.setFill(Color.BLUE);
        gc.fillRect(200,400,200,20);
        gc.fillOval(200,430,200,100);

        gc.setFill(Color.BLACK);
        gc.fillText("Rysowanie jest super.", 400, 500);
        double x = canvas.getWidth() / 2;
        double y = canvas.getHeight() / 2;
        gc.fillText("Pierwsza litera jest na (" + x + "," + y + ")", x, y);
    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
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
        result.ifPresent(res -> System.out.println(res));
    }
}
