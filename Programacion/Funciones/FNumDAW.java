package Programacion.Funciones;

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

    // Función posicionDeDigito: Da la posición de la primera ocurrencia de un dígito dentro de un número entero. Si no se encuentra, devuelve -1.
    public static int posicionDeDigito(int numero, int digito) {
        String numeroStr;
        String digitoStr;
        int posicion;
        numeroStr = String.valueOf(numero);
        digitoStr = String.valueOf(digito);
        posicion = numeroStr.indexOf(digitoStr);
        return posicion;
    }

    // Función parteNumero: Toma como parámetros las posiciones inicial y final dentro de un número y devuelve el ‘trozo’ correspondiente.
    public static int parteNumero(int numero, int inicio, int fin) {
        String numeroStr;
        String parteStr;
        int parteNumero;
        numeroStr = String.valueOf(numero);
        parteStr = numeroStr.substring(inicio, fin + 1);
        parteNumero = Integer.parseInt(parteStr);
        return parteNumero;
    }

    // Función pegaNumeros: Pega dos números para formar uno.
    public static int pegaNumeros(int numero1, int numero2) {
        String numero1Str;
        String numero2Str;
        String resultadoStr;
        int resultado;
        numero1Str = String.valueOf(numero1);
        numero2Str = String.valueOf(numero2);
        resultadoStr = numero1Str + numero2Str;
        resultado = Integer.parseInt(resultadoStr);
        return resultado;
    }

    // Función esKaprekar: Verifica si un número es de Kaprekar.
    public static boolean esKaprekar(int numero) {
        int cuadrado;
        String parte1Str;
        String cuadradoStr;
        String parte2Str;
        int parteuna;
        int longitud;
        int partedos;
        boolean resultado = false;
        cuadrado = numero * numero;
        cuadradoStr = String.valueOf(cuadrado);
        longitud = cuadradoStr.length();
        for (int i = 1; i < longitud; i++) {
            parte1Str = cuadradoStr.substring(0, i);
            parte2Str = cuadradoStr.substring(i);
            parteuna = Integer.parseInt(parte1Str);
            partedos = Integer.parseInt(parte2Str);
            
            if (parteuna + partedos == numero) {
                resultado = true;
            }
        }
        return resultado;
    }
}
