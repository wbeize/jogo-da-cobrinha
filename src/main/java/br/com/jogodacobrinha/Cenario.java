package br.com.jogodacobrinha;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
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
}
