import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        int[][] raya = new int[3][3];
        Scanner sc = new Scanner(System.in);
        int posibiliddades = 1;
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
            System.out.println("\u250c\u2500\u252C\u2500\u252C\u2500\u2510");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == 0){
                        System.out.print("\u2502");
                    }
                    System.out.print(raya[i][j]);
                    if (j < 2) {
                        System.out.print("\u2502");
                    }
                }
                System.out.println("\u2502");
                if (i < 2) {
                    System.out.println("\u251C\u2500\u253C\u2500\u253C\u2500\u2524");
                }
            }
            System.out.println("\u2514\u2500\u2534\u2500\u2534\u2500\u2518");
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
            // Vamos a combrobar ganador usuario
            // Limpiar la pantalla
            System.out.print("\033[H\033[2J");
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
                    ganador = 
                    true;
                }

                if (raya[2][0] == 1 && raya[1][1] == 1 && raya[0][2] == 1) {
                    System.out.println("GANA JUGADOR");
                    posibiliddades = 100;
                    ganador = true;
                }

            }
            // Acabamos de comprobar
            if (!ganador) {
                // Turno de la maq
                while (ComprobarMaq) {
                    fila = (int) (Math.random() * 3);
                    columna = (int) (Math.random() * 3);
                    if (raya[fila][columna] == 0) {
                        ComprobarMaq = false;
                    }
                }
                raya[fila][columna] = 2;
            }

            posibiliddades = posibiliddades + 2;

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
        }else{
            
            System.out.println("\u250c\u2500\u252C\u2500\u252C\u2500\u2510");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == 0){
                        System.out.print("\u2502");
                    }
                    System.out.print(raya[i][j]);
                    if (j < 2) {
                        System.out.print("\u2502");
                    }
                }
                System.out.println("\u2502");
                if (i < 2) {
                    System.out.println("\u251C\u2500\u253C\u2500\u253C\u2500\u2524");
                }
            }
            System.out.println("\u2514\u2500\u2534\u2500\u2534\u2500\u2518");
        }
    }
}
