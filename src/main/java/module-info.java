module br.com.jogodacobrinha {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.jogodacobrinha to javafx.fxml;
    exports br.com.jogodacobrinha;
}