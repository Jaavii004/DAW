import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Datos {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("file1.txt");
            fw.write("Hola, esto es un ejemplo de FileWriter\nOK");
            fw.close(); // Mete el contenido en el fichero
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter pw = new PrintWriter("file1.txt");
            pw.println("Hola, esto es un ejemplo de PrintWriter");
            pw.printf("Este es un número: %d", 42);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
