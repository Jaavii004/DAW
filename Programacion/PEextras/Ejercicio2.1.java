import java.util.Scanner;

public class CalculadoraRPN {

    public static void main(String[] args) {
        double[] registros = new double[4];
	char[] letras = {'D', 'C', 'B' ,'A'};
        int registroActual = 0;
        Scanner scanner = new Scanner(System.in);
        boolean salir = true;

        while (salir) {
	    
            for (int i = 3; i >= 0; i--) {
		System.out.print(letras[i] + " ");
                System.out.println(registros[i] + " ");
            }

            System.out.print("Pon numero (Q para salir): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("Q")) {
                salir = false;
            } else {
		double numero = Double.parseDouble(input);
		registros[registroActual] = numero;
                registroActual = (registroActual + 1) % 4;

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
                            System.out.println("Error: No se dividir.");
                            
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
