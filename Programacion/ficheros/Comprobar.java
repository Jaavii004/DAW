import java.io.File;

public class Comprobar {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, proporciona un nombre de archivo o directorio como argumento.");
            return;
        }
        
        String path = args[0];
        File file = new File(path);
        
        if (!file.exists()) {
            System.out.println("El archivo o directorio especificado no existe.");
            return;
        }
        
        System.out.println("Ruta: " + file.getAbsolutePath());
        long fileSizeInBytes = file.length();
        double fileSizeInGigabytes = (double) fileSizeInBytes / (1024 * 1024 * 1024);
        System.out.println("Tamaño: " + fileSizeInGigabytes + " GB");
        System.out.println("Permisos: " + (file.canRead() ? "Legible " : "") + (file.canWrite() ? "Escribible " : "") + (file.canExecute() ? "Ejecutable" : ""));
        
        if (file.isDirectory()) {
            System.out.println("Tipo: Directorio");
        } else {
            System.out.println("Tipo: Archivo");
        }
    }
}
