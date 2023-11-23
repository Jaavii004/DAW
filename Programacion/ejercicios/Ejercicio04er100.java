import java.util.Scanner;
import funciones.FNumDAW;

public class Ejercicio04er100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        char letra;
        String palabra;
        int contador = 0;
        int suma;
        num = sc.nextInt();
        do {
            palabra = sc.next();
            suma = 0;
            // Recorrer todas las letras de la palabra y sumarlas
            for (int i = 0; i < palabra.length(); i++) {
                letra = palabra.charAt(i);
                suma += letra;
            }
            int antprim = FNumDAW.anteriorPrimo(suma);
            System.out.println(antprim);
            contador++;
        } while (contador < num);
        sc.close();
    }
    
}
