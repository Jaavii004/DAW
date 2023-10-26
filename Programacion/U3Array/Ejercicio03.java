package Programacion.U3Array;
import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        int filas = 4;
        int columnas = 4;
        int[][] matriz = new int[filas][columnas];

        Scanner scanner = new Scanner(System.in);

        // Ingresar elementos de la matriz
        System.out.println("Ingresa los elementos de la matriz (4x4):");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento en la posición [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Verificar si la matriz es simétrica
        boolean esSimetrica = true;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    esSimetrica = false;
                    break;
                }
            }
            if (!esSimetrica) {
                break;
            }
        }

        // Mostrar la matriz
        System.out.println("La matriz ingresada es:");
        mostrarMatriz(matriz);

        // Mostrar si es simétrica o no
        if (esSimetrica) {
            System.out.println("La matriz es simétrica.");
        } else {
            System.out.println("La matriz no es simétrica.");
        }
    }

    public static void mostrarMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
