package Programacion.Estrusturasdinamicas;

import java.util.Scanner;
import java.util.Stack;

public class Estadistica {
    public static double Media(Stack<Double> numeros) {
        double suma = 0;
        double resultado = 0;
        for (Double d : numeros) {
            suma += d;
        }
        if (numeros.size() != 0) {
            resultado = suma / numeros.size();
        }
        return resultado;
    }
    public static double desviacionTipica(Stack<Double> numeros) {
        if (numeros.isEmpty()) {
            return 0;
        }
        double media = Media(numeros);
        double resultado = 0;
        double sumares= 0;
        double resSum = 0;
        double resultadofinal;

        for (double num : numeros) {
            resultado = num - media;
            resultado = resultado*resultado;
            sumares += resultado;
        }
        resSum = sumares / numeros.size();
        resultadofinal = Math.sqrt(resSum);

        return resultadofinal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Double> numeros = new Stack<>();
        String entrada = "";
        double entradaNumero = 0;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Media: "+Media(numeros)+"           D.tipica: "+desviacionTipica(numeros));
            System.out.print(": ");
            entrada = sc.nextLine();
            if (entrada.matches("-?\\d+(\\.\\d+)?")) {
                entradaNumero = Double.parseDouble(entrada);
                numeros.push(entradaNumero);
            }
        } while (!entrada.equalsIgnoreCase("q"));
        sc.close();
    }
}