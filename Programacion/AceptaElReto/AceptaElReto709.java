package Programacion.AceptaElReto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AceptaElReto709 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxVotos=0;
        Map<String, Integer> votos = new HashMap<>();
        int numVotos=0;
        boolean salir = false;
        String ganador = "EMPATE";
        String pais="";
        int votosconseguidos = 0;

        while (!salir) {
            numVotos = sc.nextInt();
            if (numVotos != 0) {
                maxVotos = 0;
                ganador = "EMPATE";

                for (int i = 0; i < numVotos; i++) {
                    pais = sc.next();
                    if (votos.containsKey(pais)) {
                        votosconseguidos = votos.get(pais)+1;
                    }else {
                        votosconseguidos = 1;
                    }
                    votos.put(pais, votosconseguidos);

                    if (votosconseguidos > maxVotos) {
                        maxVotos = votosconseguidos;
                        ganador = pais;
                    } else if (votosconseguidos == maxVotos) {
                        ganador = "EMPATE";
                    }
                }
                System.out.println(ganador);
                votos.clear();
            }else{
                salir=true;
            }
        }
        sc.close();
    }
}