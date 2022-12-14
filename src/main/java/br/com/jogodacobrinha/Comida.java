package br.com.jogodacobrinha;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Comida {

    private Canvas comida;

    public Comida(){
        criarComida();
        setPosicaoAleatoria();
    }

    public void criarComida() {
        this.comida = CanvasUtils.buildSquare(Color.SADDLEBROWN);
    }

    public void setPosicaoAleatoria() {
        this.comida.setTranslateX(numAleatorio(0,Configs.WIDTH - Configs.SQUARE_SIZE));
        this.comida.setTranslateY(numAleatorio(0,Configs.HEIGHT - Configs.SQUARE_SIZE));

    }

    private Integer numAleatorio(Integer min, Integer max) {
        int valor = (int) (Math.random() * ((max - min) + 1)) + min;
        return valor - (valor %  Configs.SQUARE_SIZE);
    }

    public Canvas getComida() {
        return comida;
    }

    public Integer getPosicaoX(){
        return (int)this.comida.getTranslateX();
    }

    public Integer getPosicaoY(){
        return (int)this.comida.getTranslateY();
    }
}
