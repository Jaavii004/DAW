package Programacion.AceptaElReto;

import java.util.Scanner;
import java.util.TreeMap;

public class AceptaElReto702_op {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int mov = sc.nextInt();
        TreeMap<String, Integer> meses = new TreeMap<>();

        // añado los 12 meses a 0 recorriendolos todos
        for (int i = 1; i <= 12; i++) {
            String MesCon0 = String.format("%02d", i);
            meses.put(MesCon0, 0);
        }

        // voy a obtener la entrada y quedarme solo con el mes
        // despues lo añado sumando a si habia algo antes si no al 0 inicializado al principio
        for (int i = 0; i < mov; i++) {
            String mes = sc.next();
            int Dineromes = sc.nextInt();
            sc.nextLine();
            mes = mes.substring(mes.indexOf("-")+1);
            meses.put(mes, meses.get(mes) + Dineromes); 
        }

        // Vamos a recorrer todos los meses y voy mostrando el resultado
        for (String mesesString : meses.keySet()) {
            int dinDelMes = meses.get(mesesString);
            total += dinDelMes;
            if (mesesString.equals("12")) {
                System.out.print(total);
            } else {
                System.out.print(total + " ");
            }
        }
        sc.close();
    }
}