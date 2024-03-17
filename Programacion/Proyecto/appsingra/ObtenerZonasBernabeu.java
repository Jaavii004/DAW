import java.util.ArrayList;
import java.util.List;

public class ObtenerZonasBernabeu {
    public static List<String> obtenerZonas() {
        List<String> zonas = new ArrayList<>();

        // Agregar las zonas del estadio Bernabéu a la lista
        zonas.add("Lateral Este");
        zonas.add("Lateral Oeste");
        zonas.add("Fondo Norte");
        zonas.add("Fondo Sur");

        return zonas;
    }
}
