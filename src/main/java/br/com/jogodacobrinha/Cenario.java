package br.com.jogodacobrinha;

import javafx.scene.Group;
import javafx.scene.Scene;
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

        root.getChildren();
    }
}
