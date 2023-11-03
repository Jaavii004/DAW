import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        int filas = 4;
        int columnas = 4;
        int[][] num = new int[filas][columnas];
        boolean simetrica = true;
        Scanner sc = new Scanner(System.in);
        // Ingresar elementos de la matriz
        System.out.println("Ingresa los elementos de la matriz (4x4):");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento en la posición [" + i + "][" + j + "]: ");
                num[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (num[i][j] != num[j][i]) {
                    simetrica = false;
                    break;
                }
            }
        }
        if (simetrica) {
            System.out.println("La matriz es simétrica");
        } else {
            System.out.println("La matriz no es simétrica");
        }
        System.out.print("\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(num[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}