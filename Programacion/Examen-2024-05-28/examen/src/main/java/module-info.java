module com.javier {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.javier to javafx.fxml;
    exports com.javier;
}
