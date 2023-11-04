import java.util.Scanner;

public class DNIClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Dni;
        int resto;
        char dni;
        System.out.print("Yo te dire la letra ");
        System.out.print("Numero del DNI: ");
        Dni = sc.nextInt();
        resto = Dni % 23;
        dni = DNI(resto);

        System.out.println("Tu letra es "+dni+".");
        System.out.println("Tu DNI queda asi "+Dni+dni+".");
    }
    public static char DNI(int resto) {
        char [] letras = {'T', 'R', 'W', 'A', 'G', 'M',  'Y', 'F', 'P',  'D', 'X', 'B',  'N', 'J', 'Z',  'S', 'Q', 'V',  'H', 'L', 'C',  'K', 'E'};
        return letras[resto];

    }
}
