import java.io.PrintWriter;
import java.util.Scanner;

public class GuardaUsu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usuario = "";
        String contra = "";
        PrintWriter file = null;
        try {
            file = new PrintWriter("UsuContra.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (!usuario.equals("salir")) {
            System.out.print("Usuario (salir para irte): ");
            usuario = sc.nextLine();
            if (!usuario.equals("salir")) {
                System.out.print("Contraseña: ");
                contra = sc.nextLine();
                try {
                    file.printf(usuario+":"+contra);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        file.close();
        sc.close();
    }
}
