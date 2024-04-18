package com.proyecto;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrincipalController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
