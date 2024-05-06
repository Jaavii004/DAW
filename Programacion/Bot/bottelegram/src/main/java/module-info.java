module com.javier {
    requires javafx.controls;
    requires javafx.fxml;
    requires telegrambots.meta;
    requires telegrambots;
    requires itextpdf;

    opens com.javier to javafx.fxml;
    exports com.javier;
}
