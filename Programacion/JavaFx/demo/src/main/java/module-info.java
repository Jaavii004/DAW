module dorsfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens dorsfx to javafx.fxml;
    exports dorsfx;
}
