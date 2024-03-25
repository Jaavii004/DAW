import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LicenseServer {
    private static final int SERVER_PORT = 8080;
    private static final String DB_URL = "jdbc:sqlite:licenses.db";

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);
        server.createContext("/verificarLicencia", new LicenseHandler());
        server.setExecutor(null); // Usaremos el hilo predeterminado
        server.start();
        System.out.println("Servidor HTTP iniciado en el puerto " + SERVER_PORT);        
    }

    static class LicenseHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String requestMethod = exchange.getRequestMethod();
            if (requestMethod.equalsIgnoreCase("GET")) {
                String query = exchange.getRequestURI().getQuery();
                String[] params = query.split("="); // Suponiendo que la solicitud tiene la forma "?clave=valor"
                if (params.length == 2 && params[0].equals("clave")) {
                    String clave = params[1];
                    boolean isValidLicense = checkLicenseValidity(clave);
                    if (isValidLicense) {
                        exchange.sendResponseHeaders(200, 0); // OK
                    } else {
                        exchange.sendResponseHeaders(404, 0); // No encontrado
                    }
                } else {
                    exchange.sendResponseHeaders(400, 0); // Solicitud inválida
                }
            } else {
                exchange.sendResponseHeaders(405, 0); // Método no permitido
            }
            exchange.getResponseBody().close();
        }

        private boolean checkLicenseValidity(String clave) {
            String sql = "SELECT valida FROM licenses WHERE clave = ?";
            try (
                Connection conn = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, clave);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    return rs.getBoolean("valida");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false; // Si no se encuentra la clave o hay un error, se considera como no válida
        }
    }
}
 