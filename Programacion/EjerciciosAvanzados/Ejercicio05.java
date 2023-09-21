import java.util.*;
class Ejercicio04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int numicazuela;
        int numihuevos;

        System.out.print("Cuantos huevos caben en la cazuela? ");
        numicazuela = sc.nextInt();

        System.out.print("Cuantos huevos quieres cocer? ");
        numihuevos = sc.nextInt();

        System.out.println("En la cazuela caben "+numicazuela+" huevos.");
        System.out.println("Quieres cocer "+numihuevos+" huevos.");

        int pasado = (numihuevos % numicazuela);
        if ( pasado == 0 ) {
            int cazuelas = numihuevos / numicazuela;
            cazuelas = cazuelas * 10;
            System.out.println("Tardaras en cocer todos los huevos "+cazuelas+" minutos");
        } else {
            int cazuelas = numihuevos / numicazuela;
            cazuelas = cazuelas + 1;
            cazuelas = cazuelas * 10;
            System.out.println("Tardaras en cocer todos los huevos "+cazuelas+" minutos");
        }
    }
}
