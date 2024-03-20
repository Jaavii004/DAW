import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObtenerAsientosBernabeu {
    public static Map<String, List<String>> obtenerAsientos() {
        Map<String, List<String>> asientos = new HashMap<>();

        // Zona: Lateral Este
        List<String> asientosLateralEste = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            asientosLateralEste.add("Lateral Este" + i); // T representa Tribuna
        }
        asientos.put("Lateral Este", asientosLateralEste);

        // Zona: Lateral Oeste
        List<String> asientosLateralOeste = new ArrayList<>();
        for (int i = 1; i <= 150; i++) {
            asientosLateralOeste.add("Lateral Oeste" + i); // G representa Grada
        }
        asientos.put("Lateral Oeste", asientosLateralOeste);

        // Zona: Fondo Norte
        List<String> asientosFondoNorte = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            asientosFondoNorte.add("Fondo Norte" + i); 
        }
        asientos.put("Fondo Norte", asientosFondoNorte);

        // Zona: Fondo Sur
        List<String> asientosFondoSur = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            asientosFondoSur.add("Fondo Sur" + i); // FS representa Fondo Sur
        }
        asientos.put("Fondo Sur", asientosFondoSur);

        return asientos;
    }
}
