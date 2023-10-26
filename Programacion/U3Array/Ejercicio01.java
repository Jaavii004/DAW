import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Creo el array de 15 elementos
        int[] num = new int[15];
        int[] numVolteado = new int[15];

        // Pido los 15 números y los guardo
        for (int i = 0; i < 15; i++) {
            System.out.print("Numero "+(i+1)+": ");
            num[i] = sc.nextInt();
        }

        System.out.println("Rotado: ");
        numVolteado[0] = num[14];
        for (int o = 0; o < 14; o++) {
            numVolteado[o+1] = num[o];
        }
        
        for (int o = 0; o < 15; o++) {
            System.out.print(numVolteado[o]+" ");
        }
        System.out.print("\n");
    }
}
