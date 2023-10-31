import java.util.Random;

public class Ejercicio02 {
    public static void main(String[] args) {
        Random random = new Random();
        int dado1 = 0;
        int dado2 = 2;
        do{
            dado1 = random.nextInt(6) + 1;
            dado2 = random.nextInt(6) + 1;
            System.out.println("Dado 1: "+dado1);
            System.out.println("Dado 2: "+dado2);
        }while (dado1 != dado2);
        System.out.println("Los dados sacaron " + dado1);
    }
}