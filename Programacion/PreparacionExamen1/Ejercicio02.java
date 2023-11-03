import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Creo el array de 15 elementos
        int[][] num = new int[3][3];
        int[][] seg = new int[3][3];
        int PrimNum;
        boolean igual = true;

        // Pido los 15 números y los guardo
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                 System.out.print("prim ["+i+"]["+j+"]: ");
                 num[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                 System.out.print("seg ["+i+"]["+j+"]: ");
                 seg[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (num[i][j] != seg[i][j]) {
                    igual = false;
                }
            }
        }

        if (igual) {
            System.out.println("Matriz igual");
        }else{
            System.out.println("Matriz diferente");
        }
    }
}
