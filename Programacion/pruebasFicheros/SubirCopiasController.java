import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;

import com.jaavii004.controladores.Copias;
import com.jaavii004.controladores.Impresoras;
import com.jaavii004.controladores.Logs;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

public class SubirCopiasController {
    private Statement st = iniciarSesionController.getSt();

    @FXML
    private Button selecArchivo;

    @FXML
    private void selecArchivo() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Archivo de copias");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos CSV", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(selecArchivo.getScene().getWindow());
        if (selectedFile != null) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(selectedFile));
                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        String[] str = line.split(",");
                        int id = Integer.parseInt(str[0]);
                        int c_color = Integer.parseInt(str[1]);
                        int c_BN = Integer.parseInt(str[2]);
                        if (Impresoras.CombrobarExiste(st, id)) {
                            Copias.CrearHistCopias(st, id, c_color, c_BN);
                        }
                    } catch (NumberFormatException e) {
                        Logs.log(e);
                    }
                }
                br.close();
            } catch (IOException ex) {
                Logs.log(ex);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Importación exitosa");
            alert.setHeaderText(null);
            alert.setContentText("Todos los datos han sido importados correctamente.");
            alert.showAndWait();
            selectedFile = null;
            // Cerrar la ventana
            selecArchivo.getScene().getWindow().hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Archivo no seleccionado");
            alert.setHeaderText(null);
            alert.setContentText("No se ha seleccionado ningún archivo.");
            alert.showAndWait();
        }
    }
}
