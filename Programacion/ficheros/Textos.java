import java.io.PrintWriter;
import java.util.Scanner;

public class Textos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = "";
        String NomFichero = "";

        System.out.print("Dime el nombre del fichero: ");
        NomFichero = sc.nextLine();
        PrintWriter file = null;
        try {
            file = new PrintWriter(NomFichero);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        while (!entrada.equals("salir")) {
            System.out.print("Dime que quieres añadir: ");
            entrada = sc.nextLine();
            if (!entrada.equals("salir")) {
                try {
                    file.printf(entrada);
                    file.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        file.close();
        sc.close();
    }
}