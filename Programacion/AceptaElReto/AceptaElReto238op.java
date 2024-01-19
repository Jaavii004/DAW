package Programacion.AceptaElReto;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AceptaElReto238op {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> billetes = new LinkedList<Integer>();
        boolean salir = false;
        int numBilletes = 0;
        int numPerso = 0;
        int veces = 0;
        int sumatotal = 0;
        String salida = "";
        while (!salir) {
            numBilletes = sc.nextInt();
            numPerso = sc.nextInt();
            String[] salidaStrings = new String[numPerso];
            if (numBilletes == 0 | numPerso == 0) {
                salir = true;
            }else{
                sc.nextLine();
                for (int i = 1; i <= numBilletes; i++) {
                    billetes.add(sc.nextInt());
                    //System.out.println("persona "+i%numPerso);
                }
                for (int i = 0; i < numPerso; i++) {
                    veces = 0;
                    sumatotal = 0;
                    salida = "";
                    for (Integer tt : billetes) {
                        veces++;
                        //int pers = veces%numPerso;
                        if (veces%numPerso == i) {
                            salida += " ";
                            salida += Integer.toString(tt);
                            billetes.remove(veces);
                            sumatotal += tt;
                        }
                    }
                    salidaStrings[i] = sumatotal + ":" + salida;
                }
                for (int i = numPerso-1; i >= 0; i--) {
                    System.out.println(salidaStrings[i]);
                }
                System.out.println("---");
                billetes.clear();
            }
        }
        sc.close();
    }
}