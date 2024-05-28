import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RPNController {
    @FXML
    private TextField textField;
    @FXML
    private Button[] buttons;

    private double[] stack = new double[9];
    private int stackIndex = 0;

    @FXML
    public void initialize() {
        for (int i = 0; i < 9; i++) {
            stack[i] = 0.0;
        }
    }

    @FXML
    public void handlePlus(ActionEvent event) {
        performOperation("+");
    }

    @FXML
    public void handleMinus(ActionEvent event) {
        performOperation("-");
    }

    @FXML
    public void handleMultiply(ActionEvent event) {
        performOperation("*");
    }

    @FXML
    public void handleDivide(ActionEvent event) {
        performOperation("/");
    }

    @FXML
    public void handleOpposite(ActionEvent event) {
        double value = Double.parseDouble(textField.getText());
        value = -value;
        textField.setText(String.valueOf(value));
    }

    @FXML
    public void handleEnter(ActionEvent event) {
        double value = Double.parseDouble(textField.getText());
        stack[stackIndex] = value;
        stackIndex++;
        if (stackIndex > 8) {
            stackIndex = 8;
        }
        textField.clear();
    }

    @FXML
    public void handleClear(ActionEvent event) {
        textField.clear();
    }

    @FXML
    public void handleBack(ActionEvent event) {
        if (stackIndex > 0) {
            stackIndex--;
            textField.setText(String.valueOf(stack[stackIndex]));
        }
    }

    @FXML
    public void handleSwap(ActionEvent event) {
        if (stackIndex > 0) {
            double temp = stack[stackIndex - 1];
            stack[stackIndex - 1] = stack[stackIndex];
            stack[stackIndex] = temp;
            textField.setText(String.valueOf(stack[stackIndex]));
        }
    }

    private void performOperation(String operator) {
        if (stackIndex > 0) {
            double operand1 = stack[stackIndex - 1];
            double operand2 = Double.parseDouble(textField.getText());
            double result = 0.0;
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 == 0.0) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setContentText("División entre cero");
                        alert.showAndWait();
                    } else {
                        result = operand1 / operand2;
                    }
                    break;
            }
            stack[stackIndex - 1] = result;
            for (int i = stackIndex; i < 8; i++) {
                stack[i] = 0.0;
            }
            stackIndex--;
            textField.setText(String.valueOf(result));
        }
    }
}