import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        int base;
        int exponente;
        double resultado = 1;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Dime una base: ");
        base = sc.nextInt();
        System.out.print("Dime un exponente: ");
        exponente = sc.nextInt();

        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        
        System.out.println("El resultado de "+base+" elevado a la "+exponente+" es: "+resultado);
    }
}


