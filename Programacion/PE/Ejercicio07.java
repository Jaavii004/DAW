import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {
        int NumPc;
        int NumUsu;
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Piedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tijeras");
        do{
            System.out.print("Elige: ");
            NumUsu = sc.nextInt();
        }while (NumUsu <= 0 || NumUsu > 3);

        NumPc = (int) (Math.random() * 3) + 1;
        System.out.println("Random salio: "+NumPc);

        if ( NumPc == NumUsu ){
            System.out.println("No hay ganador. Empate");
        }
        if ( (NumUsu == 1 && NumPc == 3) || (NumUsu == 2 && NumPc == 1) || (NumUsu == 3 && NumPc == 2) ) {
            System.out.println("Has ganado.");
        }
        if ( (NumPc == 1 && NumUsu == 3) || (NumPc == 2 && NumUsu == 1) || (NumPc == 3 && NumUsu == 2) ) {
            System.out.println("Gana el Pc.");
        }
    }
}