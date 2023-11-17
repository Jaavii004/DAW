package Programacion.Funciones;

import java.lang.invoke.StringConcatFactory;
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
    public static String esCapicua(int numero) {
        int comp = numero;
        int voltear = 0;
        String resultado;
        while (numero != 0) {
            int digito = numero % 10;
            voltear = voltear * 10 + digito;
            numero /= 10;
        }
        if (comp == voltear){
            resultado = "es capicua";
        }else{
            resultado = "no es capicua";
        }
        return resultado;
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
        String EsCapicua;

        // Ejer1 calcular potencia
        System.out.print("Dime la base: ");
        Base = sc.nextInt();
        System.out.print("Dime el exp: ");
        exp = sc.nextInt();
        potencia = potencia(Base, exp);
        System.out.println("El resultado de la "+potencia);

        // Ejer2 contar numeros introducidos
        System.out.print("Numero y cuento cuantos hay: ");
        numero = sc.nextInt();
        rescad = cuentaDigitos(numero);
        System.out.println("Numero de digitos es "+rescad+" del numero "+numero);

        // Ejer3 numero volteado
        System.out.print("Numero y lo volteo: ");
        voltear = sc.nextInt();
        Volteado = voltea(voltear);
        System.out.println("Número volteado: " + Volteado);

        // Ejer4 Escapicua
        System.out.print("Numero y te digo si es capicua o no: ");
        NumCapicua = sc.nextInt();
        EsCapicua = esCapicua(voltear);
        System.out.println("Número "+NumCapicua+" "+EsCapicua);



        

        sc.close();
    }
}
