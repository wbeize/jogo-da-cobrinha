package br.com.jogodacobrinha;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotaoTenteNovamente extends VBox {

    public BotaoTenteNovamente(EventHandler<ActionEvent> action) {
        Label gameOver = new Label("CÊ MORREU!");
        gameOver.setFont(Font.font(30));
        gameOver.setTextFill(Color.RED);
        this.getChildren().add(gameOver);

        Button tenteNovamente = new Button("mas bora mais uma?");
        tenteNovamente.setFont(Font.font(15));
        tenteNovamente.setOnAction(action);
        this.getChildren().add(tenteNovamente);

        // definir tamanho no VBox

        this.setMinWidth(Configs.WIDTH);
        this.setMinHeight(Configs.HEIGHT);
        this.setAlignment(Pos.CENTER);
    }
}
