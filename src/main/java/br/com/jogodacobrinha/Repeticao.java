package br.com.jogodacobrinha;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class Repeticao {

    private Cenario cenario;
    private KeyCode direcaoAtual;
    private Cobrinha cobrinha;
    private Timeline timeline;
    private Comida comida;

    public Repeticao(Cenario cenario, Cobrinha cobrinha, Comida comida) {
        this.cenario = cenario;
        this.cobrinha = cobrinha;
        this.comida = comida;
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

    public void comecarRepeticao() {
        timeline = new Timeline();
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

            // criando condições pra morte da cobrinha

            if (    posicaoX < 0 ||//      bateu no lado esquerdo da tela
                    posicaoY < 0 ||//      bateu no topo da tela
                    posicaoX > Configs.WIDTH - Configs.SQUARE_SIZE ||
                    posicaoY > Configs.HEIGHT - Configs.SQUARE_SIZE) {

                gameOver();

            }else{

                // verificar se ocorreu a colisão da cabeça da cobra com a comida
                if(posicaoX.equals(comida.getPosicaoX()) && posicaoY.equals(comida.getPosicaoY())) { // ver se estão na mesma posição
                    this.comida.setPosicaoAleatoria();
                    this.cobrinha.comer(this.cenario);
                }

                // verificando se a cobrinha morreu ou não
                this.cobrinha.setPosicao(posicaoX,posicaoY);
            }

            this.cobrinha.setPosicao(posicaoX, posicaoY);
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Integer.MAX_VALUE);
        timeline.play();
    }

    public void gameOver() {
        this.timeline.stop();
        this.direcaoAtual=null;
        this.cobrinha.morte();
        this.cenario.showGameOver(this);
    }


}
