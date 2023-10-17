import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int primdia;
        int primhora;
        int segundia;
        int segunhora;

        System.out.print("Dime un numero positivo: ");
        numero = sc.nextInt();

        for (i = 1; i <= numero; i++) {
            for (j = i; j <= numero; j++) {
                resul = i+j+i*j;
                System.out.println(" Par ("+i+","+j+"): "+i+"+"+j+"+"+i+"*"+j+" vale "+resul);
            }
        }

    }
}
