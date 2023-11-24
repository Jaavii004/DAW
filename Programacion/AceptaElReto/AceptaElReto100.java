import java.util.Scanner;
import java.util.Arrays;

public class AceptaElReto100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        int numero;
        int num;
        int numdesc;
        int numasc;
        int numi;
        int numinteraciones;
        int[] digitos = new int[4];
        num = sc.nextInt();
        do {
            numi  = sc.nextInt();
            numero = numi;

            numinteraciones = 0;
            while (numi != 6174) {
                numinteraciones++;
                if (numinteraciones >= 8){
                    numinteraciones = 8;
                    numi = 6174;
                }
                numero = numi;
                for (int j = 0; j < 4; j++) {
                    digitos[j] = numero % 10;
                    numero /= 10;
                }
                // Ordenar en orden ascendente
                Arrays.sort(digitos);
                numasc = digitos[0] * 1000 + digitos[1] * 100 + digitos[2] * 10 + digitos[3];
                //System.out.println("numasc "+ numasc);
                
                // Ordenar en orden descendente
                for (int i = 0; i < 4; i++) {
                    for (int j = i + 1; j < 4; j++) {
                        if (digitos[i] < digitos[j]) {
                            int temp = digitos[i];
                            digitos[i] = digitos[j];
                            digitos[j] = temp;
                        }
                    }
                }
                numdesc = digitos[0] * 1000 + digitos[1] * 100 + digitos[2] * 10 + digitos[3];
                numi = numdesc-numasc;
                //System.out.println(numdesc+" - "+numasc+" = "+numi);
            }
            System.out.println(numinteraciones);
            contador++;
        } while (contador < num);
        sc.close();
    }
}