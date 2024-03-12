import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CompUsu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usu;
        String contra;
        Boolean encontrado = false;
        try {
            System.out.println();
            usu = sc.nextLine();
            contra = sc.nextLine();
            File file = new File("UsuContra.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                String[] ususplit = linea.split(":");
                if (ususplit[0].equals(usu)) {
                    if (ususplit[1].equals(contra)) {
                        System.out.println("Si pasaste");
                        encontrado = true;
                    }
                }
                linea = br.readLine();
            }
            if (!encontrado) {
                System.out.println("No lo e encontrado o esta incorrecto");
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("No existe el archivo o el directorio");
        }
    }
}
