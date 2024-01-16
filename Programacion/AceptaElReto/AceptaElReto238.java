package Programacion.AceptaElReto;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AceptaElReto238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> billetes = new LinkedList<Integer>();
        boolean salir = false;
        int numBilletes = 0;
        int numPerso = 0;
        int veces = 0;

        while (!salir) {
            numBilletes = sc.nextInt();
            numPerso = sc.nextInt();

            if (numBilletes == 0 | numPerso == 0) {
                salir = true;    
                System.out.println("salir");
            }else{
                System.out.println("seguir");
                sc.nextLine();
                for (int i = 1; i <= numBilletes; i++) {
                    billetes.add(sc.nextInt());
                    //System.out.println("persona "+i%numPerso);
                }
                //for (int i = 1; i <= numPerso; i++) {
                //    veces = 1;
                //    for (Integer tt : billetes) {
                //        if (i%numPerso == i-1) {
                //            System.out.println(i+" "+tt);
                //        }
                //        veces++;
                //    }
                //}
                veces = 0;
                for (int i = 0; i < numPerso; i++) {
                    for (Integer tt : billetes) {
                        veces++;
                        int pers = veces%numPerso;
                        if (pers == i) {
                            System.out.print(tt+" ");
                            //System.out.println("salida "+tt+" pers"+i);
                        }
                        //System.out.println("tt "+tt+" Persona ");
                    }
                    System.out.println();
                }

                System.out.println("---");
                billetes.clear();
            }
        }
        sc.close();
    }
}
