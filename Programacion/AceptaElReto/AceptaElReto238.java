package Programacion.AceptaElReto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AceptaElReto238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Queue<Integer>> arrayListDeColas = new ArrayList<>();
        boolean salir = false;
        int numBilletes = 0;
        int numPerso = 0;
        String salida = "";
        int billete = 0;

        while (!salir) {
            numBilletes = sc.nextInt();
            numPerso = sc.nextInt();
            for (int i = 0; i < numPerso; i++) {
                Queue<Integer> cola = new LinkedList<Integer>();
                arrayListDeColas.add(cola);
            }
            if (numBilletes == 0 | numPerso == 0) {
                salir = true;
            }else{
                sc.nextLine();
                int pers = 0;
                for (int i = 1; i <= numBilletes; i++) {
                    int bill = sc.nextInt();
                    arrayListDeColas.get(pers).add(bill);
                    pers++;
                    if (pers == numPerso) {
                        pers = 0;
                    }
                }
                int sumatotal = 0;
                for (Queue<Integer> queue : arrayListDeColas) {
                    sumatotal=0;
                    salida = "";
                    while (!queue.isEmpty()) {
                        billete = queue.poll();
                        salida += " "+billete;
                        sumatotal += billete;
                    }
                    System.out.println(sumatotal+":"+salida);
                }
                sc.nextLine();
                arrayListDeColas.clear();
                System.out.println("---");
            }
        }
        sc.close();
    }
}