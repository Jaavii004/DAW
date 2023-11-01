import java.util.Scanner;

public class CalculadoraRPN {

    public static void main(String[] args) {
        double[] registros = new double[4];
        int registroActual = 0;
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.print("Pila (D C B A): ");
            for (int i = 3; i >= 0; i--) {
                System.out.print(registros[i] + " ");
            }
            System.out.println();

            System.out.print("Ingrese número o operador (Q para salir): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("Q")) {
                salir = true;
            } else if (input.matches("-?\\d+(\\.\\d+)?")) {
                double numero = Double.parseDouble(input);
                registros[registroActual] = numero;
                registroActual = (registroActual + 1) % 4;
            } else {
                if (registroActual < 2) {
                    System.out.println("Error: Se requieren al menos 2 números en la pila.");
                    continue;
                }

                double b = registros[(registroActual - 1 + 4) % 4];
                double a = registros[(registroActual - 2 + 4) % 4];
                double resultado = 0;

                switch (input) {
                    case "+":
                        resultado = a + b;
                        break;
                    case "-":
                        resultado = a - b;
                        break;
                    case "*":
                        resultado = a * b;
                        break;
                    case "/":
                        if (b == 0) {
                            System.out.println("Error: División por cero.");
                            registros[registroActual] = a;
                            registroActual = (registroActual + 1) % 4;
                            registros[registroActual] = b;
                            registroActual = (registroActual + 1) % 4;
                            continue;
                        } else {
                            resultado = a / b;
                        }
                        break;
                    default:
                        System.out.println("Operador no válido: " + input);
                        continue;
                }

                registros[registroActual] = resultado;
                registroActual = (registroActual + 1) % 4;
            }
        }

        System.out.println("Calculadora RPN finalizada.");
    }
}
