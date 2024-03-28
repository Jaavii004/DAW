import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs {
    private static String rutalog = "log/";
    private static String Fecha = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    private static String hora = new SimpleDateFormat("hh:mm:ss").format(new Date());

    public static void log(Exception e) {
        File directorio = new File(rutalog);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado correctamente.");
            }
        }
        String nombreArchivo = rutalog + Fecha + ".log";
        try {
            PrintWriter fw = new PrintWriter(new FileWriter(nombreArchivo, true));
            // aqui nos quedaremos con la excepcion mas tarde
            StringWriter sw = new StringWriter();
            // aqui guradamos la excepion en el sw
            PrintWriter pw = new PrintWriter(sw);
            // guardamos en el pw la excepcion
            e.printStackTrace(pw);
            fw.println(hora + "\n" + sw.toString());
            fw.close();
        } catch (IOException o) {
            o.printStackTrace();
        }
    }
}
