import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        String Nombre;
        int numpru = 0;
        int tiempoprograma;
        System.out.print("Como te llamas? ");
        Nombre = sc.nextLine();
        System.out.println("Hola "+Nombre);
        
        do {
            System.out.print("Sabes programar? ");
            respuesta = sc.nextLine();
            numpru++;
            if (respuesta.equals("Si")) {
                numpru = 4;
                System.out.print("Cuantos años llevas programando? ");
                tiempoprograma = sc.nextInt();
                if (tiempoprograma <= 1) {
                    System.out.println("Novato!");
                }else{
                    if (tiempoprograma > 1 && tiempoprograma <= 5) {
                        System.out.println("Experto!");
                    }else{
                        System.out.println("Oh maestro, te adoramos!");
                    }
                }
            }
            if (respuesta.equals("No")) {
                numpru = 4;
                System.out.println("Loooser!");
            }
        }while (numpru < 3);
        if (numpru == 3) {
            System.out.println("Si no contestas bien me voy");
        }
    }
}
