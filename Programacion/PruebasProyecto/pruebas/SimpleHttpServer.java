import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class SimpleHttpServer {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new InicioHandler());
        server.createContext("/login", new LoginHandler());
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("Servidor iniciado en el puerto 8000...");
    }
}
