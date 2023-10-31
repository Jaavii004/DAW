import java.util.Scanner;
import java.util.Stack;

public class CalculadoraRPN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Double> pila = new Stack<>();
        boolean salir = false;

        while (!salir) {
            System.out.print("D: ");
            if (!pila.isEmpty()) {
                System.out.print(pila.pop() + " ");
            }

            System.out.print("\nC: ");
            if (!pila.isEmpty()) {
                System.out.print(pila.peek() + " ");
            }

            System.out.print("\nB: ");
            if (!pila.isEmpty()) {
                for (Double valor : pila) {
                    System.out.print(valor + " ");
                }
            }

            System.out.print("\nA: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Q")) {
                salir = true;
            } else {
                try {
                    double numero = Double.parseDouble(input);
                    pila.push(numero);
                } catch (NumberFormatException e) {
                    if (input.equals("+") && pila.size() >= 2) {
                        double b = pila.pop();
                        double a = pila.pop();
                        pila.push(a + b);
                    } else if (input.equals("-") && pila.size() >= 2) {
                        double b = pila.pop();
                        double a = pila.pop();
                        pila.push(a - b);
                    } else if (input.equals("*") && pila.size() >= 2) {
                        double b = pila.pop();
                        double a = pila.pop();
                        pila.push(a * b);
                    } else if (input.equals("/") && pila.size() >= 2) {
                        double b = pila.pop();
                        double a = pila.pop();
                        pila.push(a / b);
                    } else {
                        System.out.println("Entrada no válida.");
                    }
                }
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        System.out.println("Saliendo de la calculadora RPN.");
    }
}
