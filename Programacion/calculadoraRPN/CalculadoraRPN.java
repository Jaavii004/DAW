import java.util.Stack;

public class CalculadoraRPN {
    public static void main(String[] args) {
        // Código de prueba
        String expresion = "5 2 + 3 *";
        double resultado = calcularRPN(expresion);
        System.out.println("El resultado es: " + resultado);
    }

    public static double calcularRPN(String expresion) {
        Stack<Double> pila = new Stack<>();

        String[] elementos = expresion.split(" ");
        for (String elemento : elementos) {
            if (elemento.matches("-?\\d+(\\.\\d+)?")) {
                // Si es un número, lo agregamos a la pila
                pila.push(Double.parseDouble(elemento));
            } else {
                // Si es un operador, realizamos la operación correspondiente
                double num2 = pila.pop();
                double num1 = pila.pop();
                double resultado = 0;

                switch (elemento) {
                    case "+":
                        resultado = num1 + num2;
                        break;
                    case "-":
                        resultado = num1 - num2;
                        break;
                    case "*":
                        resultado = num1 * num2;
                        break;
                    case "/":
                        resultado = num1 / num2;
                        break;
                    default:
                        throw new IllegalArgumentException("Operador inválido: " + elemento);
                }

                // Agregamos el resultado a la pila
                pila.push(resultado);
            }
        }

        // El resultado final estará en la cima de la pila
        return pila.pop();
    }
}
