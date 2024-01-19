package Programacion.AceptaElReto;

import java.util.Scanner;

public class AceptaElReto210 {
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero <= 3) {
            return true;
        }
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }
        int divisor = 5;
        while (divisor * divisor <= numero) {
            if (numero % divisor == 0 || numero % (divisor + 2) == 0) {
                return false;
            }
            divisor += 6;
        }
        return true;
    }

    public static int anteriorPrimo(int numero) {
        do {
            numero--;
        } while (!esPrimo(numero));
        return numero;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        char letra;
        num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            String palabra = sc.nextLine();
            int suma=0;
            for (int j = 0; j < palabra.length(); j++) {
                letra = palabra.charAt(j);
                suma += letra;
            }
            
            System.out.println(anteriorPrimo(suma));
        }
        //do {
        //    String palabra = sc.nextLine();
        //    int suma = 0;
        //    // Recorrer todas las letras de la palabra y sumarlas
        //    for (int i = 0; i < palabra.length(); i++) {
        //        letra = palabra.charAt(i);
        //        suma += letra;
        //    }
        //    int antprim = anteriorPrimo(suma);
        //    System.out.println(antprim);
        //    contador++;
        //} while (contador < num);
        sc.close();
    }
}