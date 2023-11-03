import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Creo el array de 15 elementos
        int[][] num = new int[3][3];
        int PrimNum;
        boolean igual = true;

        // Pido los 15 números y los guardo
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                 System.out.print("c "+(i+1)+": ");
                 num[i][j] = sc.nextInt();
            }
        }

        PrimNum = num[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (PrimNum != num[i][j]) {
                    igual = false;
                }
            }
        }

        if (igual) {
            System.out.println("Todos los numeros iguals");
        }else{
            System.out.println("No son iguales todos los num");
        }
    }
}
