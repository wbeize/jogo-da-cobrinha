package br.com.jogodacobrinha;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Cenario {

    private Scene scene;
    private Group root = new Group();
    private Cobrinha cobrinha;

    public Cenario(Stage primaryStage, Cobrinha cobrinha) {
        this.scene = new Scene(root, Configs.WIDTH,Configs.HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("jogo da cobrinha - taira");
        primaryStage.show();

        this.cobrinha = cobrinha;

        root.getChildren().add(cobrinha.getCabeca());
    }

    public void setKeyPressed(EventHandler<? super KeyEvent> action) {
        this.scene.setOnKeyPressed(action);
    }

    public void showGameOver(Repeticao repeticao) {
        BotaoTenteNovamente botaoTenteNovamente = new BotaoTenteNovamente(e -> {
            limpar();
            this.root.getChildren().add(this.cobrinha.reset());
            repeticao.comecarRepeticao();
        });

        this.root.getChildren().add(botaoTenteNovamente);
    }

    // método para limpar a tela
    private void limpar(){
        this.root.getChildren().remove(0,this.root.getChildren().size());
    }
}
