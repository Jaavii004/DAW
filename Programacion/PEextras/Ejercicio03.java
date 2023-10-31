import java.util.Random;
import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        Random random = new Random();
        int numeroSecreto = random.nextInt(101);
        int intentos = 5;
        Scanner sc = new Scanner(System.in);
        System.out.println("\033[H\033[2J");
        while (intentos > 0) {
            System.out.println("Adivina el número secreto entre 0 y 100. Te quedan "+intentos+" oportunidades.");
            System.out.print("Adivina el número: ");
            int numero = sc.nextInt();
            System.out.println("\033[H\033[2J");
            if (numero == numeroSecreto) {
                System.out.println("¡Felicidades! Has adivinado el número secreto.");
                intentos = 0;
            }else {
                if (numero < numeroSecreto) {
                    System.out.println("El número secreto es mayor que " + numero + ".");
                } else {
                    System.out.println("El número secreto es menor que " + numero + ".");
                }
            }
            intentos--;
        }
        if (intentos == 0) {
            System.out.println("\033[H\033[2J");
            System.out.println("No te quedan intentos. El número secreto era "+numeroSecreto);
        }
    }
}