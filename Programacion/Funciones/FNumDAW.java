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
        int voltear = 0;
        while (numero != 0) {
            int digito = numero % 10;
            voltear = voltear * 10 + digito;
            numero /= 10;
        }
        return voltear;
    }
    
    public static Boolean esCapicua(int numero) {
        int comp = numero;
        int voltear = 0;
        boolean resultado;
        while (numero != 0) {
            int digito = numero % 10;
            voltear = voltear * 10 + digito;
            numero /= 10;
        }
        if (comp == voltear){
            resultado = true;
        }else{
            resultado = false;
        }
        return resultado;
    }
    
    public static boolean esPrimo(int numero) {
        boolean resultado;
        int numprim = 0;
        int divi = 1;
        if (numero % 1 != 0) {
            divi = numero+1;
            resultado = false;
        }
        while (divi <= numero) {
           if (numero % divi == 0) {
                numprim++;
            }
            divi++;
        }
        if (numprim == 2) {
            resultado = true;
        }else{
            resultado = false;
        }
        return resultado;
    }
    public static int siguientePrimo(int numero) {
        int siguiente = numero + 1;
        while (!esPrimo(siguiente)) {
            siguiente++;
        }
        return siguiente;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Base;
        int exp;
        int potencia;
        int numero;
        int rescad;
        int voltear;
        int Volteado;
        int NumCapicua;
        boolean EsCapicua;
        int NumPrimo;
        boolean EsPrimo;
        int NumSiguientePrimo;
        int SiguientePrimo;

        // Ejercicio 1 calcular potencia
        System.out.print("Dime la base: ");
        Base = sc.nextInt();
        System.out.print("Dime el exp: ");
        exp = sc.nextInt();
        potencia = potencia(Base, exp);
        System.out.println("El resultado de la "+potencia);

        // Ejercicio 2 contar numeros introducidos
        System.out.print("Numero y cuento cuantos hay: ");
        numero = sc.nextInt();
        rescad = cuentaDigitos(numero);
        System.out.println("Numero de digitos es "+rescad+" del numero "+numero);

        // Ejercicio 3 numero volteado
        System.out.print("Numero y lo volteo: ");
        voltear = sc.nextInt();
        Volteado = voltea(voltear);
        System.out.println("Número volteado: " + Volteado);

        // Ejercicio 4 Escapicua
        System.out.print("Numero y te digo si es capicua o no: ");
        NumCapicua = sc.nextInt();
        EsCapicua = esCapicua(NumCapicua);
        System.out.println("Número "+NumCapicua+" "+(EsCapicua?"es capicua":"no es capicua"));

        
        // Ejercicio 5 esPrimo
        System.out.print("Numero y te digo si es primo o no: ");
        NumPrimo = sc.nextInt();
        EsPrimo = esPrimo(NumPrimo);
        System.out.println("Número "+NumPrimo+" "+(EsPrimo?"es primo":"no es primo"));

        
        // Ejercicio 5 siguientePrimo
        System.out.print("Numero y te digo el siguiente primo: ");
        NumSiguientePrimo = sc.nextInt();
        SiguientePrimo = siguientePrimo(NumPrimo);
        System.out.println("Número "+NumSiguientePrimo+" el siguiente primo es "+SiguientePrimo);

        sc.close();
    }
}
