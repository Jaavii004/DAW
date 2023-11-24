import java.util.Scanner;
import funciones.FNumDAW;
import java.util.Arrays;

public class Ejercicio04er100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        int num;
        int numdesc;
        int numasc;
        int numi;
        int numinteraciones;
        int[] digitos = new int[4];
        num = sc.nextInt();
        do {
            numi  = sc.nextInt();
            numinteraciones = 0;
            while (numi != 6174) {
                numinteraciones++;

                // Ordenar los dígitos en orden ascendente
                digitos[0] = numi % 10;
                digitos[1] = (numi / 10) % 10;
                digitos[2] = (numi / 100) % 10;
                digitos[3] = (numi / 1000) % 10;
                Arrays.sort(digitos);
                numasc = digitos[0] * 1000 + digitos[1] * 100 + digitos[2] * 10 + digitos[3];
                String numascStr = String.format("%04d", numasc);
                numasc = Integer.parseInt(numascStr);

                // Ordenar los dígitos en orden descendente
                numdesc = FNumDAW.voltea(numasc);
                String numdescStr = String.format("%04d", numdesc);
                numdesc = Integer.parseInt(numdescStr);
                

                numi = numdesc-numasc;
                System.out.println(numdesc+" - "+numasc+" = "+numi);
            }
            System.out.println(numinteraciones);
            contador++;
        } while (contador < num);
        sc.close();
    }
}
