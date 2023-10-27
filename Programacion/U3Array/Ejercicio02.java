package Programacion.U3Array;

import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        int[][] raya = new int[3][3];
        Scanner sc = new Scanner(System.in);
        int posivilidades = 0;
        int fila = 0;
        int columna = 0;
        boolean ganador = false;
        boolean Comprobar;

        // Limpiar la pantalla
        System.out.print("\033[H\033[2J");

        while (posivilidades <= 9) {
            Comprobar = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(raya[i][j]);
                    if (j < 2) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
                if (i < 2) {
                    System.out.println("___________");
                }
            }

            // Turno del jugador
            System.out.println("Jugador (1):");
            while (Comprobar) {
                do {
                    System.out.println("Introduce una fila: (0-2)");
                    fila = sc.nextInt();
                } while (fila <= 0 || fila >= 2);

                do {
                    System.out.println("Introduce una columna: (0-2)");
                    columna = sc.nextInt();
                } while (columna <= 0 || columna >= 2);
                if (raya[fila][columna] == ' ') {
                    Comprobar = false;
                }
            }
            if (raya[fila][columna] == ' ') {
                Comprobar = false;
            }
        }
        if (!ganador) {
            System.out.println("No hay ganador");
        }
    }
}
