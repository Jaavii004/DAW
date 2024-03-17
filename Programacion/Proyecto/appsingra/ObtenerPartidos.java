import java.util.HashMap;

public class ObtenerPartidos {
    public static HashMap<Integer, String> listado() {
        HashMap<Integer, String> lista = new HashMap<>();

        // Agregar partidos al HashMap
        lista.put(1, "Real Madrid - Barcelona");
        lista.put(2, "Manchester United - Liverpool");
        lista.put(3, "Bayern Munich - Borussia Dortmund");
        lista.put(4, "Juventus - Inter Milan");

        return lista;
    }
}
