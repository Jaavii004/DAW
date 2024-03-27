import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs {
    private static String rutalog = "log/";
    private static String Fecha = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    public static void log(String mensaje) {
        String nombreArchivo = rutalog + "miniAdv - " + Fecha + ".log";
        try (
            PrintWriter fw = new PrintWriter(new FileWriter(nombreArchivo, true))) {
            fw.println(Fecha + " - \n " + mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
