import java.io.File;

public class rmj {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Tienes que poner java rmj fichero.txt");

        }else{
            String filename = args[0];
            File file = new File(filename);
            
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("Eliminado.");
                } else {
                    System.out.println("Fallo al eliminar.");
                }
            } else {
                System.out.println("Ese archivo no existe.");
            }
        }
    }
}