import java.io.File;

public class Comprobar {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("java Comprobar Fichero/archivo");
        }else{
            String arg = args[0];
            File file = new File(arg);
            
            if (!file.exists()) {
                System.out.println("El archivo o directorio especificado no existe.");
                return;
            }
            
            System.out.println("Ruta: " + file.getAbsolutePath());
            long By = file.length();
            double Gb = (double) By / (1024 * 1024 * 1024);
            System.out.println("Tamaño: " + Gb + " GB");
            System.out.println("Permisos: " + (file.canRead() ? "Legible " : "") + (file.canWrite() ? "Escribible " : "") + (file.canExecute() ? "Ejecutable" : ""));
            
            if (file.isDirectory()) {
                System.out.println("Tipo: Directorio");
            } else {
                System.out.println("Tipo: Archivo");
            }
        }
    }
}
