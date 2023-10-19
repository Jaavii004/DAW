import java.util.Scanner;

public class Ejercicio08 {
    public static void main(String[] args) {
        int NumPc;
        int NumUsu;
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Piedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tijeras");
        System.out.println("4 - Lagarto");
        System.out.println("5 - Spock");
        do{
            System.out.print("Elige: ");
            NumUsu = sc.nextInt();
        }while (NumUsu <= 0 || NumUsu > 5);

        NumPc = (int) (Math.random() * 5) + 1;
        System.out.println("Random salio: "+NumPc);

        if ( NumPc == NumUsu ){
            System.out.println("No hay ganador. Empate");
        }
        if ((NumUsu == 1 && (NumPc == 3 || NumPc == 4)) || (NumUsu == 2 && (NumPc == 1 || NumPc == 5)) || (NumUsu == 3 && (NumPc == 2 || NumPc == 4)) || (NumUsu == 4 && (NumPc == 2 || NumPc == 5)) || (NumUsu == 5 && (NumPc == 1 || NumPc == 3)) ) {
            System.out.println("Has ganado.");
        }
        if ((NumPc == 1 && (NumUsu == 3 || NumUsu == 4)) || (NumPc == 2 && (NumUsu == 1 || NumUsu == 5)) || (NumPc == 3 && (NumUsu == 2 || NumUsu == 4)) || (NumPc == 4 && (NumUsu == 2 || NumUsu == 5)) || (NumPc == 5 && (NumUsu == 1 || NumUsu == 3)) ) {
            System.out.println("Gana el Pc.");
        }
    }
}