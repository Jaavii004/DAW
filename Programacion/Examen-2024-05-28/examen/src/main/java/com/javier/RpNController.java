package com.javier;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RpNController {
    private double[] array = new double[9];
    @FXML
    private Label label0;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;

    @FXML
    private Label numvol;

    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button buttonpun;

    @FXML
    public void initialize() {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
        llenarPila();
        numvol.setText("");
        button0.setOnAction(event -> obtNum(0));
        button1.setOnAction(event -> obtNum(1));
        button2.setOnAction(event -> obtNum(2));
        button3.setOnAction(event -> obtNum(3));
        button4.setOnAction(event -> obtNum(4));
        button5.setOnAction(event -> obtNum(5));
        button6.setOnAction(event -> obtNum(6));
        button7.setOnAction(event -> obtNum(7));
        button8.setOnAction(event -> obtNum(8));
        button9.setOnAction(event -> obtNum(9));
    }

    private void obtNum(int id) {
        String st = numvol.getText();
        numvol.setText(st+id);
    }

    @FXML
    private void buttonpun() {
        String st = numvol.getText();
        if (!st.contains(".")) {
            numvol.setText(st+".");
        }
    }

    @FXML
    private void pulsEnter() {
        if (numvol.getText().equals("")) {
            return;
        }
        Double dou;
        try {
            dou = Double.parseDouble(numvol.getText());
        } catch (Exception e) {
            return;
        }
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = dou;
        llenarPila();
        numvol.setText("");
    }

    @FXML
    private void sum() {
        double sum = array[0] + array[1];
        for (int i = 1; i < array.length-1; i++) {
            array[i] = array[i + 1];
        }
        array[0] = sum;
        array[8] = 0;
        llenarPila();
    }

    @FXML
    private void res() {
        double res = array[1] - array[0];
        for (int i = 1; i < array.length-1; i++) {
            array[i] = array[i + 1];
        }
        array[0] = res;
        array[8] = 0;
        llenarPila();
    }

    @FXML
    private void mul() {
        double mul = array[0] * array[1];
        for (int i = 1; i < array.length-1; i++) {
            array[i] = array[i + 1];
        }
        array[0] = mul;
        array[8] = 0;
        llenarPila();
    }

    @FXML
    private void cambSig() {
        double num = Double.parseDouble(numvol.getText());
        numvol.setText(""+-num);
    }

    @FXML
    private void div() {
        if (array[0] == 0.0) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("División entre Cero");
            alert.showAndWait();
            return;
        }
        double div = array[1] / array[0];
        for (int i = 1; i < array.length-1; i++) {
            array[i] = array[i + 1];
        }
        array[0] = div;
        array[8] = 0;
        llenarPila();
    }

    // Botón C
    @FXML
    private void Limpiar() {
        numvol.setText("");
    }

    // Botón <-
    @FXML
    private void elimpri() {
        for (int i = 0; i < array.length-1; i++) {
            array[i] = array[i + 1];
        }
        array[8] = 0;
        llenarPila();
    }

    // Botón <>
    @FXML
    private void cambiarundos() {
        double tmp = array[1];
        array[1] = array[0];
        array[0] = tmp;
        llenarPila();
    }

    private void llenarPila() {
        label0.setText(""+array[0]);
        label1.setText(""+array[1]);
        label2.setText(""+array[2]);
        label3.setText(""+array[3]);
        label4.setText(""+array[4]);
        label5.setText(""+array[5]);
        label6.setText(""+array[6]);
        label7.setText(""+array[7]);
        label8.setText(""+array[8]);
    }
}

