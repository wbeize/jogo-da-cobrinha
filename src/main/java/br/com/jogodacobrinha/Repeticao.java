package br.com.jogodacobrinha;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class Repeticao {

    private Cenario cenario;
    private KeyCode direcaoAtual;
    private Cobrinha cobrinha;

    public Repeticao(Cenario cenario, Cobrinha cobrinha) {
        this.cenario = cenario;
        this.cobrinha = cobrinha;
        this.cenario.setKeyPressed(e->{
            KeyCode keyPressed = e.getCode();

            if (keyPressed.equals(KeyCode.RIGHT)) {
                direcaoAtual = keyPressed;
            }

            if (keyPressed.equals(KeyCode.LEFT)) {
                direcaoAtual = keyPressed;
            }

            if (keyPressed.equals(KeyCode.UP)) {
                direcaoAtual = keyPressed;
            }

            if (keyPressed.equals(KeyCode.DOWN)) {
                direcaoAtual = keyPressed;
            }
        });

        comecarRepeticao();
    }

    private void comecarRepeticao() {
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(200), e-> {
            Integer posicaoX = cobrinha.getPosicaoX();
            Integer posicaoY = cobrinha.getPosicaoY();

            if(KeyCode.RIGHT.equals(direcaoAtual)) {
                posicaoX = posicaoX + Configs.SQUARE_SIZE;
            }

            if(KeyCode.LEFT.equals(direcaoAtual)) {
                posicaoX = posicaoX - Configs.SQUARE_SIZE;
            }

            if(KeyCode.UP.equals(direcaoAtual)) {
                posicaoY = posicaoY - Configs.SQUARE_SIZE;
            }

            if(KeyCode.DOWN.equals(direcaoAtual)) {
                posicaoY = posicaoY + Configs.SQUARE_SIZE;
            }

            this.cobrinha.setPosicao(posicaoX, posicaoY);
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Integer.MAX_VALUE);
        timeline.play();

    }
}
