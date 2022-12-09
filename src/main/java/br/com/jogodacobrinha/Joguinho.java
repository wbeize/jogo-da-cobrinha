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
        new Cenario(primaryStage, cobrinha);

    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
    }
}

