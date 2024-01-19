package Programacion.AceptaElReto;

import java.util.Scanner;
import java.util.Arrays;

public class AceptaElReto115 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int num;
        int numdesc;
        int numasc;
        int numi;
        int numinteraciones;
        int[] digitos = new int[4];
        boolean esKaprekar;
        num = sc.nextInt();
        for (int o = 1; o < num; o++) {
            numi  = sc.nextInt();
            if (numi == 0) {
                o = num;
            }else{
                numero = numi;
                esKaprekar = true;
                numinteraciones = 0;
                while (numi != 6174) {
                    numinteraciones++;
                    if (numinteraciones >= 8){
                        numinteraciones = 8;
                        numi = 6174;
                        esKaprekar = false;
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
                    numdesc = digitos[3] * 1000 + digitos[2] * 100 + digitos[1] * 10 + digitos[0];
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
                }
                if (esKaprekar) {
                    System.out.println("SI");
                }else{
                    System.out.println("NO");
                }
            }            
        }
        sc.close();
    }
}