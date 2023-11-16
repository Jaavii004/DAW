package Programacion.Funciones;

import java.util.Scanner;

public class FNumDAW {
    public static int potencia(int Base, int exp) {
        int resultado = 1;
        for (int i = 0; i < exp; i++) {
            resultado *= Base;
        }
        return resultado;
    }
    public static int cuentaDigitos(int numero) {
        String numeroComoCadena;
        int cant = 0;
        numeroComoCadena = String.valueOf(numero);
        cant = numeroComoCadena.length();
        return cant;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ejer1 calcular potencia
        System.out.print("Dime la base: ");
        int Base = sc.nextInt();
        System.out.print("Dime el exp: ");
        int exp = sc.nextInt();
        int potencia = potencia(Base, exp);
        System.out.println("El resultado de la "+potencia);

        // Ejer2 contar numeros introducidos
        int numero = sc.nextInt();
        int rescad = cuentaDigitos(numero);
        System.out.println("Numero de digitos es "+rescad+" del numero "+numero);
        sc.close();
    }
}
