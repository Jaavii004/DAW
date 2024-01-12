package Programacion.Estrusturasdinamicas;

import java.util.Scanner;
import java.util.Stack;

public class CalculadoraRPN {
    public static void Mostrarstak(Stack<Double> pila) {
        int tam = pila.size();
        for (Double d : pila) {
            String numerocon0 = String.format("%02d", tam);
            System.out.println(numerocon0+":    "+d);
            tam--;
        }
        System.out.println("Pulsa q para salir");
    }
    public static void main(String[] args) {
        // Crear una pila
        Stack<Double> pila = new Stack<>();

        Scanner sc = new Scanner(System.in);
        boolean salir;
        String entrada = "";
        double resultado = 0;
        double num1;
        double num2;
        
        salir = false;
        while (!salir) {
            Mostrarstak(pila);
            System.out.print(": ");
            entrada = sc.nextLine();
            if (entrada.matches("-?\\d+(\\.\\d+)?")) {
                double numeroDouble = Double.parseDouble(entrada);
                pila.push(numeroDouble);
            } else {
                if (pila.size() == 0) {
                    num1 = 0;
                    num2 = 0;
                }else if (pila.size() == 1) {               
                    num2 = pila.pop();
                    num1 = 0;
                   
                } else {
                    num2 = pila.pop();
                    num1 = pila.pop();
                }
                switch (entrada) {
                    case ("q"):
                        salir = true;
                        break;
                    case ("+"):
                        resultado = num1+num2;
                        pila.push(resultado);
                        break;
                    case ("*"):
                        resultado = num1*num2;
                        pila.push(resultado);
                        break;
                    case ("/"):
                        resultado = num1/num2;
                        pila.push(resultado);
                        break;
                    case ("-"):
                        resultado = num1-num2;
                        pila.push(resultado);
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }
        }
        sc.close();
    }
}