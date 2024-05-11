import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheros {
    public static void main(String[] args) {
        System.out.println("Leyendo fichero");
        try {
            FileReader fr = new FileReader("Usuarios.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            while ((linea = br.readLine()) != null) {
                Usuarios usuario = obtenerUsuarioDesdeLinea(linea);
                System.out.println("Nombre del usuario: " + usuario.getNombre());
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error de E/S");
        }
    }

    public static Usuarios obtenerUsuarioDesdeLinea(String linea) {
        String[] datos = linea.split(",");
        int id_usuario = Integer.parseInt(datos[0]);
        String nombre = datos[1];
        String apellidos = datos[2];
        String grado = datos[3];
        int edad = Integer.parseInt(datos[4]);
        return new Usuarios(id_usuario, nombre, apellidos, grado, edad);
    }

    public void reemplazarComas(String linea) {
        String lineaSinComas = linea.replace(",", " ");
        System.out.println(lineaSinComas);
    }

    /*
    public void quitarComas(String linea) {
        String[] campos = linea.split(",");
        for (String campo : campos) {
            System.out.println(campo);
        }
    }
    */
}
