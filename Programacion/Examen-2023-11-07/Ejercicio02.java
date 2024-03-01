import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numfila = new int[5];
        int[] numestre = new int[2];
        int numapu = 0;
        int numale;
        System.out.print("Numero de apuestas? ");
        numapu = sc.nextInt();
        System.out.println("");

        for (int i = 0; i < numapu ; i++) {
            for (int j = 0; j < 5 ; j++) {
                boolean igual = true;
                do {
                    numale = (int) (Math.random() * 50) + 1;
                    for (int k = 0; k < 5; k++) {
                        if (numfila[k] != numale){
                            igual = false;
                        }
                    }
                }while (igual);
                numfila [j] = numale;
            }
            Arrays.sort(numfila);
            for (int j = 0; j < 5; j++) {
                if (numfila[j] >= 0 && numfila[j] <= 9){
                    System.out.print("0"+numfila[j]+ " ");
                }else{
                    System.out.print(numfila[j] + " ");
                }
            }
            System.out.print("+ ");
            numale = 0;
            for (int j = 0; j < 2 ; j++) {
                boolean igualestre = true;
                do {
                    numale = (int) (Math.random() * 10) + 1;
                    for (int k = 0; k < 2; k++) {
                        if (numestre[k] != numale){
                            igualestre = false;
                        }
                    }
                }while (igualestre);
                numestre[j] = numale;
            }
            Arrays.sort(numestre);
            for (int j = 0; j < 2; j++) {
                System.out.print(numestre[j]+" ");
            }
            System.err.println();
        }
    }
}
