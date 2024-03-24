import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class VerificadorLicencia {

    // Método para obtener la clave de licencia desde un archivo
    private String obtenerClaveLicencia() {
        try (BufferedReader br = new BufferedReader(new FileReader("license.txt"))) {
            return br.readLine(); // Devuelve la primera línea del archivo (la clave de licencia)
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para verificar la licencia utilizando un servidor externo
    public boolean verificarLicencia() {
        String clave = obtenerClaveLicencia();
        if (clave == null) {
            System.out.println("No se pudo obtener la clave de licencia del archivo.");
            return false;
        }

        try {
            // URL del servidor que verifica la licencia
            String urlServidor = "https://tu-servidor.com/verificarLicencia?clave=" + clave;
            
            // Realizar la solicitud HTTP GET al servidor
            URL url = new URL(urlServidor);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Leer la respuesta del servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String respuesta;
            StringBuilder response = new StringBuilder();

            while ((respuesta = in.readLine()) != null) {
                response.append(respuesta);
            }
            in.close();

            // Interpretar la respuesta del servidor
            // Aquí podrías tener lógica para analizar la respuesta y determinar si la licencia es válida

            // Por ejemplo, supongamos que el servidor responde con "true" si la licencia es válida
            return response.toString().equals("true");

        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de errores de conexión o de servidor
            return false;
        }
    }

    public static void main(String[] args) {
        VerificadorLicencia verificador = new VerificadorLicencia();

        if (verificador.verificarLicencia()) {
            System.out.println("¡La licencia es válida! Puede usar la aplicación.");
        } else {
            System.out.println("La licencia no es válida. No puede usar la aplicación.");
        }
    }
}
