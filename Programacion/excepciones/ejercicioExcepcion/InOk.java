package Programacion.excepciones.ejercicioExcepcion;

import java.util.Scanner;

public class InOk {
    private static Scanner sc = new Scanner(System.in);
    private static int num;

    public static void LeeInt(){
        try {
            System.out.print("LeeInt(): ");
            sc.nextInt();
        } catch (Exception e) {
            System.out.println("Error no es un numero entero ");
            sc.nextLine();
        }
    }

    public static void LeeIntPos(){
        try {
            System.out.print("LeeIntPos(): ");
            sc.nextLine();
            num = sc.nextInt();
            if (num < 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error numero no positivo");
            sc.nextLine();
        }
    }

    public static void LeeIntRango(){
        System.out.print("LeeIntRango(): ");

        try {
            num = sc.nextInt();
            if ((num > 100) || (num < 0)) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Número fuera del rango [0,100]");
            sc.nextLine();
        }
    }

    public static void LeeDou(){
        try {
            
            num = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Error no es un numero real");
            sc.nextLine();
        }
    }

    public static void LeeDouRango(){
        try {
            System.out.print("LeeDouRango(): ");
            LeeDou();
            if ((num > 100) || (num < 0)) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Número fuera del rango [0,100]");
            sc.nextLine();
        }
    }
    public static void main(String[] args) {
        LeeInt();
        LeeIntPos();
        LeeIntRango();
        System.out.print("LeeDou(): ");
        LeeDou();
        LeeDouRango();
    }
}
