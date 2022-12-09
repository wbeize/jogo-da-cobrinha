package br.com.jogodacobrinha;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class CanvasUtils {

    public static Canvas buildSquare(Paint color) {
        Canvas square =  new Canvas(Configs.SQUARE_SIZE, Configs.SQUARE_SIZE);
        GraphicsContext gc = square.getGraphicsContext2D();
        gc.setFill(color);

        return square;
    }

}