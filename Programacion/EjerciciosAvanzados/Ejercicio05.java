import java.util.*;
class Ejercicio04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int numinsectos;

        System.out.print("Numero de insectos = ");
        numinsectos = sc.nextInt();
        int patasinsectos = (numinsectos * 6);
        System.out.println("Los "+numinsectos+" insectos tienen "+patasinsectos+" patas.\n");

    }
}