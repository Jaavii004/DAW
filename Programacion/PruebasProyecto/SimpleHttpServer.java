import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;

public class SimpleHttpServer {
    private static final Map<String, String> userCredentials = new HashMap<>();
    static {
        // Agregar credenciales de usuario
        userCredentials.put("admin", "admin");
    }

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(8000), 0);
        server.createContext("/", new MyHandler());
        server.start();
        System.out.println("Servidor iniciado en el puerto 8000...");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String requestMethod = exchange.getRequestMethod();
            if (requestMethod.equalsIgnoreCase("GET")) {
                String requestedFile = exchange.getRequestURI().getPath();
                if (requestedFile.equals("/") || requestedFile.equals("/index.html")) {
                    sendFileResponse(exchange, "./index.html", "text/html");
                } else if (requestedFile.endsWith(".css")) {
                    sendFileResponse(exchange, "." + requestedFile, "text/css");
                } else if (requestedFile.equals("/login")) {
                    sendLoginForm(exchange);
                } else if (requestedFile.equals("/welcome")) {
                    sendWelcomePage(exchange);
                } else {
                    sendFileResponse(exchange, "./404.html", "text/html");
                }
            } else if (requestMethod.equalsIgnoreCase("POST")) {
                String requestedFile = exchange.getRequestURI().getPath();
                if (requestedFile.equals("/login")) {
                    handleLogin(exchange);
                }
            }
        }

        private void sendLoginForm(HttpExchange exchange) throws IOException {
            String response = "<html><head><title>Login</title></head><body>"
                            + "<h2>Login</h2>"
                            + "<form method='post' action='/login'>"
                            + "Username: <input type='text' name='username'><br>"
                            + "Password: <input type='password' name='password'><br>"
                            + "<input type='submit' value='Login'>"
                            + "</form>"
                            + "</body></html>";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        private void handleLogin(HttpExchange exchange) throws IOException {
            // Leer los datos de inicio de sesión del cuerpo de la solicitud
            String requestBody = new String(exchange.getRequestBody().readAllBytes());
            String[] credentials = requestBody.split("&");
            String username = credentials[0].split("=")[1];
            String password = credentials[1].split("=")[1];

            // Verificar las credenciales
            if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
                // Redirigir al usuario a la página de bienvenida
                exchange.getResponseHeaders().set("Location", "/welcome?username=" + username);
                exchange.sendResponseHeaders(302, -1);
            } else {
                // Si las credenciales son incorrectas, redirigir al usuario de vuelta al formulario de inicio de sesión
                exchange.getResponseHeaders().set("Location", "/login");
                exchange.sendResponseHeaders(302, -1);
            }
        }

        private void sendWelcomePage(HttpExchange exchange) throws IOException {
            String username = exchange.getRequestURI().getQuery().split("=")[ 1];
            String response = "<html><head><title>Bienvenido</title></head><body>"
                            + "<h2>Bienvenido, " + username + "!</h2>"
                            + "</body></html>";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        private void sendFileResponse(HttpExchange exchange, String filePath, String contentType) throws IOException {
            byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
            exchange.getResponseHeaders().set("Content-Type", contentType);
            exchange.sendResponseHeaders(200, fileBytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(fileBytes);
            os.close();
        }
    }
}
