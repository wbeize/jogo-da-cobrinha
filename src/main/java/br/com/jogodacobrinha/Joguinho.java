package br.com.jogodacobrinha;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class Joguinho extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Cobrinha cobrinha = new Cobrinha();
        Comida comida = new Comida();
        Cenario cenario = new Cenario(primaryStage, cobrinha, comida);
        Repeticao repeticao = new Repeticao(cenario, cobrinha, comida);
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
    }
}

