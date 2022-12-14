package br.com.jogodacobrinha;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Cobrinha {

    private Canvas cabeca;
    private List<Canvas> corpo = new ArrayList<>();
    private List<Integer[]> historicoPosicoes = new ArrayList<>();

    public Cobrinha() {
        criarCobrinha();
    }

    private void criarCobrinha() {
        this.cabeca = CanvasUtils.buildSquare(Color.BEIGE);
        resetarPosicao();

    }

    private void resetarPosicao(){
        this.cabeca.setTranslateX(Configs.WIDTH / 2 - Configs.SQUARE_SIZE);
        this.cabeca.setTranslateY(Configs.HEIGHT / 2 - Configs.SQUARE_SIZE);
    }

    public Canvas getCabeca() {
        return cabeca;
    }

    public Integer getPosicaoX() {
        return (int) this.cabeca.getTranslateX();
    }

    public Integer getPosicaoY() {
        return (int) this.cabeca.getTranslateY();
    }

    public void setPosicao(Integer x, Integer y) {
        this.cabeca.setTranslateX(x);
        this.cabeca.setTranslateY(y);

        // criando método pra fazer a cabeça guiar o corpo e o histórico ficar

        for (int i = 0; i<corpo.size(); i++) {
            Canvas maisCorpo = corpo.get(i);
            Integer[] posicao = this.historicoPosicoes.get(this.historicoPosicoes.size() - (i + 1));
            maisCorpo.setTranslateX(posicao[0]);
            maisCorpo.setTranslateY(posicao[1]);
        }

        this.historicoPosicoes.add(new Integer[] {x,y});

        // remover histórico que não precisamos do corpo

        if (historicoPosicoes.size() > corpo.size()+1) {
            historicoPosicoes.remove(0);
        }
    }

    public Canvas reset(){
        resetarPosicao();
        return this.cabeca;
    }

    public void morte() {
        GraphicsContext gc = this.getCabeca().getGraphicsContext2D();
        gc.clearRect(0,0,Configs.SQUARE_SIZE, Configs.SQUARE_SIZE);
        gc.setFill(Color.RED);
        gc.fillRect(0,0,Configs.SQUARE_SIZE, Configs.SQUARE_SIZE);
    }

    public void comer(Cenario cenario) {
        Canvas maisCorpo = CanvasUtils.buildSquare(Color.BEIGE);
        cenario.add(maisCorpo);
        this.corpo.add(maisCorpo);
    }
}