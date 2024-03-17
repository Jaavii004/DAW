import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interfaz {
    // Método para imprimir los asientos de 10 en 10 por línea
    public static void imprimirAsientos(List<String> asientos) {
        for (int i = 0; i < asientos.size(); i++) {
            System.out.print(asientos.get(i) + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println(); // Salto de línea después de imprimir 10 asientos
            }
        }
        System.out.println(); // Salto de línea adicional al final
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entradas");
        System.out.println("salir");
        System.out.print("opcion: ");
        String d = sc.nextLine();

        HashMap<Integer, String> lista = ObtenerPartidos.listado();

        // Mostrar los elementos del HashMap
        for (Integer key : lista.keySet()) {
            String value = lista.get(key);
            System.out.println("- " + key + ". " + value);
        }
        System.out.print("que partido quieres(numero): ");
        int parti = sc.nextInt();
        sc.nextLine();

        System.out.println("Has elegido el partido: "+lista.get(parti));

        List<String> zonas = ObtenerZonasBernabeu.obtenerZonas();

        System.out.println("Zonas del Estadio Bernabéu:");
        for (String zona : zonas) {
            System.out.println(zona);
        }
        String zonaber = sc.nextLine();
        Map<String, List<String>> asientosBernabeu = ObtenerAsientosBernabeu.obtenerAsientos();
        
        // Imprimir los asientos del estadio Bernabéu por zona
        System.out.println("Asientos del Estadio Bernabéu:");
        for (String zona : asientosBernabeu.keySet()) {
            if (zona.equals(zonaber)) {
                System.out.println("Zona: " + zona);
                List<String> asientos = asientosBernabeu.get(zona);
                imprimirAsientos(asientos);
            }
        }

        sc.close();
    }
    
}
