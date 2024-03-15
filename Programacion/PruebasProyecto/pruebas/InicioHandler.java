import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InicioHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Ruta del archivo HTML
        String htmlFilePath = "index.html";
        // Ruta del archivo CSS
        String cssFilePath = "./style.css";
        
        // Leer el contenido del archivo HTML
        byte[] htmlFileBytes = Files.readAllBytes(Paths.get(htmlFilePath));

        // Configurar el tipo de contenido para HTML
        exchange.getResponseHeaders().set("Content-Type", "text/html");

        // Configurar la respuesta HTTP con el código de estado 200 (OK) para HTML
        exchange.sendResponseHeaders(200, htmlFileBytes.length);

        // Obtener el cuerpo de la respuesta para escribir en él
        OutputStream responseBody = exchange.getResponseBody();

        // Escribir el contenido del archivo HTML en el cuerpo de la respuesta
        responseBody.write(htmlFileBytes);

        // Cerrar el flujo de salida
        responseBody.close();

        // Si el archivo CSS existe, enviarlo después de enviar el HTML
        if (Files.exists(Paths.get(cssFilePath))) {
            // Leer el contenido del archivo CSS
            byte[] cssFileBytes = Files.readAllBytes(Paths.get(cssFilePath));

            // Configurar el tipo de contenido para CSS
            exchange.getResponseHeaders().set("Content-Type", "text/css");

            // Configurar la respuesta HTTP con el código de estado 200 (OK) para CSS
            exchange.sendResponseHeaders(200, cssFileBytes.length);

            // Obtener el cuerpo de la respuesta para escribir en él
            OutputStream cssResponseBody = exchange.getResponseBody();

            // Escribir el contenido del archivo CSS en el cuerpo de la respuesta
            cssResponseBody.write(cssFileBytes);

            // Cerrar el flujo de salida
            cssResponseBody.close();
        }
    }
}
