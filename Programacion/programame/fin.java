import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class fin  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int numEquipos = Integer.parseInt(scanner.nextLine().trim());
            if (numEquipos == 0) {
                break;
            }

            String[] equipos = scanner.nextLine().split("\\s+");
            Map<String, Integer> puntuaciones = new HashMap<>();

            // Inicializar puntuaciones
            for (String equipo : equipos) {
                puntuaciones.put(equipo, 0);
            }

            // Procesar resultados de la fase de grupos
            String[] resultadosFaseGrupos = scanner.nextLine().split("\\s+");
            for (String resultado : resultadosFaseGrupos) {
                int equipo1 = Integer.parseInt(resultado.substring(0, 1)) - 1;
                int equipo2 = Integer.parseInt(resultado.substring(1, 2)) - 1;

                puntuaciones.put(equipos[equipo1], puntuaciones.get(equipos[equipo1]) + 1);
            }

            // Procesar resultados de la fase eliminatoria
            for (int i = 0; i < numEquipos / 4; i++) {
                String resultado = scanner.nextLine();
                int equipo1 = Integer.parseInt(resultado.substring(0, 1)) - 1;
                int equipo2 = Integer.parseInt(resultado.substring(1, 2)) - 1;

                if (puntuaciones.get(equipos[equipo1]) > puntuaciones.get(equipos[equipo2])) {
                    puntuaciones.put(equipos[equipo1], puntuaciones.get(equipos[equipo1]) + 1);
                } else {
                    puntuaciones.put(equipos[equipo2], puntuaciones.get(equipos[equipo2]) + 1);
                }
            }

            // Encontrar al equipo ganador
            String ganador = "";
            int maxPuntuacion = -1;
            for (Map.Entry<String, Integer> entry : puntuaciones.entrySet()) {
                if (entry.getValue() > maxPuntuacion) {
                    maxPuntuacion = entry.getValue();
                    ganador = entry.getKey();
                }
            }

            // Imprimir el nombre del equipo ganador
            System.out.println(ganador);
        }
    }
}
