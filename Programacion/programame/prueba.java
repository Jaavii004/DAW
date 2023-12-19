import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class prueba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el número de votos
            int n = scanner.nextInt();

            // Verificar si se llegó al final de la entrada
            if (n == 0) {
                break;
            }

            // Leer los votos y contar la frecuencia de cada candidatura
            Map<String, Integer> conteo = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String voto = scanner.next();
                conteo.put(voto, conteo.getOrDefault(voto, 0) + 1);
            }

            // Determinar la candidatura ganadora o si hay empate
            String ganador = null;
            int maxVotos = 0;
            for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
                if (entry.getValue() > maxVotos) {
                    ganador = entry.getKey();
                    maxVotos = entry.getValue();
                }
            }
            final int  next = maxVotos; 

            // Imprimir la salida
            long count = 0;
            for (int value : conteo.values()) {
                if (value == next) {
                    count++;
                }
            }
            if (count > 1) {
                System.out.println("EMPATE");
            } else {
                System.out.println(ganador);
            }
        }
    }
}
