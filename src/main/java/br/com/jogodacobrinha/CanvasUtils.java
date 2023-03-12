package br.com.jogodacobrinha;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class CanvasUtils {

    public static Canvas buildSquare(Paint color) {
        Canvas quadrado =  new Canvas(Configs.SQUARE_SIZE, Configs.SQUARE_SIZE);
        GraphicsContext gc = quadrado.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0,0,Configs.SQUARE_SIZE,Configs.SQUARE_SIZE);
        return quadrado;
    }
}