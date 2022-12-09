package br.com.jogodacobrinha;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Cobrinha {

    private Canvas cabeca;
    public Cobrinha() {
        criarCobrinha();
    }

    private void criarCobrinha() {
        this.cabeca = CanvasUtils.buildSquare(Color.BEIGE);
        this.cabeca.setTranslateX(Configs.WIDTH/2 - Configs.SQUARE_SIZE);
        this.cabeca.setTranslateY(Configs.HEIGHT/2 - Configs.SQUARE_SIZE);
    }

    public Canvas getCabeca() {
        return cabeca;
    }

}
