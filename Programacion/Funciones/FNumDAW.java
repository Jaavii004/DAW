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
    public static int voltea(int numero) {
        int resto;
        int ivert = 0;
        while (numero > 0) {
            resto = numero % 10;
            ivert = ivert * 10 + resto;
            numero /= 10;
        }
        return ivert;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Base;
        int exp;
        int potencia;
        int numero;
        int rescad;
        int voltea;
        int resvolt;

        // Ejer1 calcular potencia
        System.out.print("Dime la base: ");
        Base = sc.nextInt();
        System.out.print("Dime el exp: ");
        exp = sc.nextInt();
        potencia = potencia(Base, exp);
        System.out.println("El resultado de la "+potencia);

        // Ejer2 contar numeros introducidos
        numero = sc.nextInt();
        rescad = cuentaDigitos(numero);
        System.out.println("Numero de digitos es "+rescad+" del numero "+numero);

        // Ejer2 contar numeros introducidos
        voltea = sc.nextInt();
        resvolt = cuentaDigitos(voltea);
        System.out.println("Numero volteado "+resvolt);


        sc.close();
    }
}
