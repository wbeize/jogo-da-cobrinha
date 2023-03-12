package br.com.jogodacobrinha;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Cenario {
    private Scene scene;
    private Group root = new Group();
    private Cobrinha cobrinha;
    private Comida comida;

    public Cenario(Stage primaryStage, Cobrinha cobrinha, Comida comida) {
        this.scene = new Scene(root, Configs.WIDTH,Configs.HEIGHT);
        this.scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("jogo da cobrinha - taira");
        primaryStage.show();

        this.cobrinha = cobrinha;
        this.comida = comida;

        root.getChildren().add(cobrinha.getCabeca());
        root.getChildren().add(comida.getComida());
    }

    public void setKeyPressed(EventHandler<? super KeyEvent> action) {
        this.scene.setOnKeyPressed(action);
    }

    public void showGameOver(Repeticao repeticao) {
        BotaoTenteNovamente botaoTenteNovamente = new BotaoTenteNovamente(e -> {
            limpar();
            this.root.getChildren().add(this.cobrinha.resetar());
            this.root.getChildren().add(this.comida.getComida());

            repeticao.comecarRepeticao();
        });

        this.root.getChildren().add(botaoTenteNovamente);
    }

    // método para limpar a tela
    private void limpar(){
        this.root.getChildren().remove(0,this.root.getChildren().size());
    }

    public void add(Node node) {
        this.root.getChildren().add(node);
    }
}
