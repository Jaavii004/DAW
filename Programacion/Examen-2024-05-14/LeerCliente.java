import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerCliente {
    public static void main(String[] args) {
        try {
            File f = new File("Clientes.csv");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                String[] lin = linea.split(",");
                System.out.println(lin[1]);
                linea = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
