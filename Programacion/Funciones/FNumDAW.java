package Programacion.Funciones;

import java.util.Scanner;

public class FNumDAW {
    // Función potencia: Calcula la potencia de un número dado una base y un exponente.
    public static int potencia(int Base, int exp) {
        int resultado = 1;
        for (int i = 0; i < exp; i++) {
            resultado *= Base;
        }
        return resultado;
    }

    // Función cuentaDigitos: Cuenta la cantidad de dígitos de un número dado.
    public static int cuentaDigitos(int numero) {
        String numeroComoCadena;
        int cant = 0;
        numeroComoCadena = String.valueOf(numero);
        cant = numeroComoCadena.length();
        return cant;
    }

    // Función voltea: Invierte el orden de los dígitos de un número dado.
    public static int voltea(int numero) {
        int voltear = 0;
        while (numero != 0) {
            int digito = numero % 10;
            voltear = voltear * 10 + digito;
            numero /= 10;
        }
        return voltear;
    }

    // Función esCapicua: Verifica si un número es capicúa, es decir, si se lee igual de izquierda a derecha y de derecha a izquierda.
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

    // Función esPrimo: Verifica si un número es primo, es decir, si solo es divisible por 1 y por sí mismo.
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

    // Función siguientePrimo: Encuentra el siguiente número primo mayor al número dado.
    public static int siguientePrimo(int numero) {
        do{
            numero++;
        }while (!esPrimo(numero));
        return numero;
    }

    // Función anteriorPrimo: Encuentra el número primo anterior al número dado.
    public static int anteriorPrimo(int numero) {
        do{
            numero--;
        }while (!esPrimo(numero));
        return numero;
    }

    // Función digitoN: Obtiene el dígito en la posición n de un número dado.
    public static int digitoN(int numero, int n) {
        int digito;
        String numeroStr;
        char digitoenChar;
        numeroStr = String.valueOf(numero);
        digitoenChar = numeroStr.charAt(n);
        digito = Character.getNumericValue(digitoenChar);
        return digito;
    }

    // Función posicionDeDigito: vamos a devolver el digito que pida del numero
    public static int posicionDeDigito(int numero, int digito) {
        String numeroStr;
        String digitoStr;
        int posicion;
        numeroStr = String.valueOf(numero);
        digitoStr = String.valueOf(digito);
        posicion = numeroStr.indexOf(digitoStr);
        return posicion;
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
        int NumAnteriorPrimo;
        int AnteriorPrimo;

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

        
        // Ejercicio 6 siguientePrimo
        System.out.print("Numero y te digo el siguiente primo: ");
        NumSiguientePrimo = sc.nextInt();
        SiguientePrimo = siguientePrimo(NumSiguientePrimo);
        System.out.println("Número "+NumSiguientePrimo+" el siguiente primo es "+SiguientePrimo);

        // Ejercicio 7 anteriorPrimo
        System.out.print("Numero y te digo el anterior primo: ");
        NumAnteriorPrimo = sc.nextInt();
        AnteriorPrimo = anteriorPrimo(NumAnteriorPrimo);
        System.out.println("Número "+NumAnteriorPrimo+" el anterior primo es "+AnteriorPrimo);
        
        int NumDigiton;
        int digiton;
        int Diginum;
        // Ejercicio 8 digitoN
        System.out.print("Numero: ");
        NumDigiton = sc.nextInt();
        System.out.print("n: ");
        Diginum =sc.nextInt();
        digiton = digitoN(NumDigiton , Diginum);
        System.out.println(digiton);

        sc.close();
    }
}
