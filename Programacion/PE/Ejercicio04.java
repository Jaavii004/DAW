import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int numprim = 0;
        int divi = 1;

        System.out.print("Dime un numero y te dire si es primo o no: ");
        numero = sc.nextInt();

        if (numero % 1 != 0) {
            divi = numero+1;
            System.out.println("El número "+numero+" no es primo.");
        }

        while (divi <= numero) {
           if (numero % divi == 0) {
                numprim++;
            }
            divi++;
        }

        if (numprim == 2) {
            System.out.println("El número "+numero+" es primo.");
        }else{
            System.out.println("El número "+numero+" no es primo.");
        }

    }
}
