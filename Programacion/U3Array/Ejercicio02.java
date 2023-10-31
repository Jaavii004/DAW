import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        int[][] raya = new int[3][3];
        Scanner sc = new Scanner(System.in);
        int posibiliddades = 0;
        int fila = 0;
        int columna = 0;
        boolean ganador = false;
        boolean ComprobarUsu;
        boolean ComprobarMaq;

        while (posibiliddades < 9) {
            // Limpiar la pantalla
            System.out.print("\033[H\033[2J");
            ComprobarUsu = true;
            ComprobarMaq = true;
            System.out.println("Persona = 1");
            System.out.println("Maquina = 2");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(raya[i][j]);
                    if (j < 2) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
                if (i < 2) {
                    System.out.println("---------");
                }
            }
            // Turno del jugador
            System.out.println("Jugador (1):");
            while (ComprobarUsu) {
                do {
                    System.out.print("Introduce una fila(0-2): ");
                    fila = sc.nextInt();
                } while (fila < 0 || fila > 2);

                do {
                    System.out.print("Introduce una columna(0-2): ");
                    columna = sc.nextInt();
                } while (columna < 0 || columna > 2);
                if (raya[fila][columna] == 0) {
                    ComprobarUsu = false;
                } else {
                    System.out.println("Casilla ya seleccionada coje otra");
                }

            }
            raya[fila][columna] = 1;

            // Turno de la maq
            while (ComprobarMaq) {
                fila = (int) (Math.random() * 3);
                columna = (int) (Math.random() * 3);
                if (raya[fila][columna] == 0) {
                    ComprobarMaq = false;
                }
            }
            raya[fila][columna] = 2;

            posibiliddades = posibiliddades + 2;

            if (!ganador) {            
                // Gana usuario en linia vertical
                for (int i = 0; i < 3; i++) {
                    if (raya[i][0] == 1 && raya[i][1] == 1 && raya[i][2] == 1) {
                        System.out.println("GANA JUGADOR");
                        posibiliddades = 100;
                        ganador = true;
                    }
                }
                // Gana usuario en linia horizontal
                for (int i = 0; i < 3; i++) {
                    if (raya[0][i] == 1 && raya[1][i] == 1 && raya[2][i] == 1) {
                        System.out.println("GANA JUGADOR");
                        posibiliddades = 100;
                        ganador = true;
                    }
                }
                // Gana maquina en diagonal
                if (raya[0][0] == 1 && raya[1][1] == 1 && raya[2][2] == 1) {
                    System.out.println("GANA JUGADOR");
                    posibiliddades = 100;
                    ganador = true;
                }

                if (raya[2][0] == 1 && raya[1][1] == 1 && raya[0][2] == 1) {
                    System.out.println("GANA JUGADOR");
                    posibiliddades = 100;
                    ganador = true;
                }

            }

            if (!ganador) {
                // Gana maquina en diagonal
                if (raya[0][0] == 1 && raya[1][1] == 1 && raya[2][2] == 1) {
                    System.out.println("GANA MAQUINA");
                    posibiliddades = 100;
                    ganador = true;
                }

                if (raya[2][0] == 1 && raya[1][1] == 1 && raya[0][2] == 1) {
                    System.out.println("GANA MAQUINA");
                    posibiliddades = 100;
                    ganador = true;
                }

                // Gana Maquina en linia vertical
                for (int i = 0; i < 3; i++) {
                    if (raya[i][0] == 2 && raya[i][1] == 2 && raya[i][2] == 2) {
                        System.out.println("GANA MAQUINA");
                        posibiliddades = 100;
                        ganador = true;
                    }
                }

                // Gana Maquina en linia horizontal
                for (int i = 0; i < 3; i++) {
                    if (raya[0][i] == 2 && raya[1][i] == 2 && raya[2][i] == 2) {
                        System.out.println("GANA MAQUINA");
                        posibiliddades = 100;
                        ganador = true;
                    }
                }
            }
        }
        if (!ganador) {
            System.out.println("No hay ganador");
        }
    }
}
