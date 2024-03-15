import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.net.URI;

public class LoginHandler implements HttpHandler {
    private static final Map<String, String> userCredentials = new HashMap<>();
    static {
        // Agregar credenciales de usuario
        userCredentials.put("admin", "admin");
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Verificar si la solicitud es de tipo POST
        if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            // Leer los datos del formulario de inicio de sesión
            String requestBody = new String(exchange.getRequestBody().readAllBytes());
            Map<String, String> formData = parseFormData(requestBody);

            // Verificar las credenciales
            if (validateCredentials(formData)) {
                // Redirigir al usuario a la página de bienvenida
                String username = formData.get("username");
                String welcomeMessage = "Bienvenido, " + username + "!";
                exchange.getResponseHeaders().set("Location", "/welcome?message=" + welcomeMessage);
                exchange.sendResponseHeaders(302, -1);
            } else {
                // Credenciales incorrectas, mostrar mensaje de error
                String response = "<html><head><title>Error</title></head><body>"
                                + "<h2>¡Error!</h2>"
                                + "<p>Credenciales incorrectas. Inténtalo de nuevo.</p>"
                                + "</body></html>";
                exchange.sendResponseHeaders(401, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        } else {
            // Si la solicitud no es de tipo POST, mostrar el formulario de inicio de sesión
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
    }

    // Método para analizar los datos del formulario y devolver un mapa de clave-valor
    private Map<String, String> parseFormData(String formData) {
        Map<String, String> result = new HashMap<>();
        String[] pairs = formData.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                result.put(keyValue[0], keyValue[1]);
            }
        }
        return result;
    }

    // Método para validar las credenciales
    private boolean validateCredentials(Map<String, String> formData) {
        String username = formData.get("username");
        String password = formData.get("password");
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }
}
