import java.io.File;
import java.io.IOException;

public class Fichero {
    public static void main(String[] args) {
        try{
            File file = new File("fichero.txt");
            if (file.createNewFile()) {
                System.out.println("Fichero creado: " + file.getName());
            } else {
                System.out.println("El fichero ya existe");
            }
        }catch (IOException e) {
            System.out.println("Error: No puedo crear el fichero");
        }
    }
}