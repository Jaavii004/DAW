package Programacion.U3Array;
import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        char[][] tablero = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        int movimientos = 0;
        boolean jugadorGano = false;
        boolean ordenadorGano = false;

        Scanner scanner = new Scanner(System.in);

        while (movimientos < 9 && !jugadorGano && !ordenadorGano) {
            // Limpiar la pantalla
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Mostrar el tablero
            mostrarTablero(tablero);

            // Turno del jugador
            System.out.println("Turno del jugador (X):");
            int fila, columna;
            do {
                System.out.print("Introduce la fila (0, 1, 2): ");
                fila = scanner.nextInt();
                System.out.print("Introduce la columna (0, 1, 2): ");
                columna = scanner.nextInt();
            } while (fila < 0 || fila > 2 || columna < 0 || columna > 2 || tablero[fila][columna] != ' ');
            tablero[fila][columna] = 'X';
            movimientos++;
            jugadorGano = verificarGanador(tablero, 'X');

            if (jugadorGano) {
                break;
            }

            // Turno del ordenador (O)
            System.out.println("Turno del ordenador (O):");
            do {
                fila = (int) (Math.random() * 3);
                columna = (int) (Math.random() * 3);
            } while (tablero[fila][columna] != ' ');
            tablero[fila][columna] = 'O';
            movimientos++;
            ordenadorGano = verificarGanador(tablero, 'O');
        }

        // Limpiar la pantalla y mostrar el resultado final
        System.out.print("\033[H\033[2J");
        System.out.flush();
        mostrarTablero(tablero);

        if (jugadorGano) {
            System.out.println("¡El jugador (X) ha ganado!");
        } else if (ordenadorGano) {
            System.out.println("¡El ordenador (O) ha ganado!");
        } else {
            System.out.println("¡Es un empate!");
        }
    }

    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public static boolean verificarGanador(char[][] tablero, char jugador) {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
                return true;
            }
        }

        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == jugador && tablero[1][j] == jugador && tablero[2][j] == jugador) {
                return true;
            }
        }

        // Verificar diagonales
        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
            return true;
        }
        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
            return true;
        }

        return false;
    }
}
