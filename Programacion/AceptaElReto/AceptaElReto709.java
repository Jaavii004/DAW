package Programacion.AceptaElReto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AceptaElReto709 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int numVotos = scanner.nextInt();
            if (numVotos == 0) {
                break;
            }

            Map<String, Integer> votos = new HashMap<>();
            int maxVotos = 0;
            String ganador = "EMPATE";

            for (int i = 0; i < numVotos; i++) {
                String candidatura = scanner.next();
                votos.put(candidatura, votos.getOrDefault(candidatura, 0) + 1);

                int votosActuales = votos.get(candidatura);
                if (votosActuales > maxVotos) {
                    maxVotos = votosActuales;
                    ganador = candidatura;
                } else if (votosActuales == maxVotos) {
                    ganador = "EMPATE";
                }
            }

            System.out.println(ganador);
        }
        
        scanner.close();
    }
}
