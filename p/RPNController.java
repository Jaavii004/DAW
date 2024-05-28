import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RPNController {
    @FXML
    private Label displayLabel;
    @FXML
    private VBox stackVBox;
    @FXML
    private Label[] stackLabels;
    @FXML
    private Button[] numberButtons;
    @FXML
    private Button[] operatorButtons;

    private double[] stack = new double[9];
    private int stackIndex = 0;
    private double currentValue = 0.0;
    private String currentOperator = "";

    @FXML
    public void initialize() {
        stackLabels = new Label[9];
        for (int i = 0; i < 9; i++) {
            stackLabels[i] = (Label) stackVBox.getChildren().get(i);
        }

        numberButtons = new Button[10];
        numberButtons[0] = (Button) getButton("0");
        numberButtons[1] = (Button) getButton("1");
        numberButtons[2] = (Button) getButton("2");
        numberButtons[3] = (Button) getButton("3");
        numberButtons[4] = (Button) getButton("4");
        numberButtons[5] = (Button) getButton("5");
        numberButtons[6] = (Button) getButton("6");
        numberButtons[7] = (Button) getButton("7");
        numberButtons[8] = (Button) getButton("8");
        numberButtons[9] = (Button) getButton("9");

        operatorButtons = new Button[5];
        operatorButtons[0] = (Button) getButton("+");
        operatorButtons[1] = (Button) getButton("-");
        operatorButtons[2] = (Button) getButton("*");
        operatorButtons[3] = (Button) getButton("/");
        operatorButtons[4] = (Button) getButton("Enter");
    }

    @FXML
    public void handleNumberButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        int number = Integer.parseInt(button.getText());
        currentValue = currentValue * 10 + number;
        displayLabel.setText(String.valueOf(currentValue));
    }

    @FXML
    public void handleOperatorButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        String operator = button.getText();
        if (operator.equals("Enter")) {
            performEnter();
        } else {
            performOperation(operator);
        }
    }

    private void performEnter() {
        stack[stackIndex] = currentValue;
        stackIndex++;
        if (stackIndex > 8) {
            stackIndex = 8;
        }
        currentValue = 0.0;
        displayLabel.setText("");
        updateStackLabels();
    }

    private void performOperation(String operator) {
        if (stackIndex > 0) {
            double operand1 = stack[stackIndex - 1];
            double operand2 = currentValue;
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
            currentValue = 0.0;
            displayLabel.setText("");
            updateStackLabels();
        }
    }

    private void updateStackLabels() {
        for (int i = 0; i < 9; i++) {
            stackLabels[i].setText(String.valueOf(stack[i]));
        }
    }

    private Button getButton(String text) {
        for (Button button : stackVBox.getScene().getRoot().lookupAll(".button")) {
            if (button.getText().equals(text)) {
                return button;
            }
        }
        return null;
    }
}