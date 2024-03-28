import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs {
    private static String rutalog = "log/";
    private static String Fecha = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    private static String hora = new SimpleDateFormat("hh:mm:ss").format(new Date());

    public static void log(String mensaje) {
        File directorio = new File(rutalog);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado correctamente.");
            }
        }
        String nombreArchivo = rutalog + Fecha + ".log";
        try {
            PrintWriter fw = new PrintWriter(new FileWriter(nombreArchivo, true));
            fw.println(hora + "\n" + mensaje);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
