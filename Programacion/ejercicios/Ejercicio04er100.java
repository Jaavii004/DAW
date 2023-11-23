import java.util.Scanner;
import java.util.Arrays;
import funciones.FNumDAW;

public class Ejercicio04er100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        int numero;
        int num;
        int numdesc;
        int numasc;
        num = sc.nextInt();
        do {
            numero = sc.nextInt();
            numdesc = numero;

            // Ordenar en orden ascendente
            Arrays.sort(numero);
            
            // Ordenar en orden descendente
            //Arrays.sort(numero);
            //Collections.reverse(Arrays.asList(numero));
            
            contador++;
        } while (contador < num);
        sc.close();
    }
    
}
