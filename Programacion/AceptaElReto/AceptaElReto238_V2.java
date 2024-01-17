package Programacion.AceptaElReto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AceptaElReto238_V2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> billetes = new ArrayList<>();
        int numBilletes;
        int numPerso;
        
        while (true) {
            numBilletes = sc.nextInt();
            numPerso = sc.nextInt();
            
            if (numBilletes == 0 || numPerso == 0) {
                break;
            }
            
            for (int i = 0; i < numBilletes; i++) {
                billetes.add(sc.nextInt());
            }
            
            int[] sumas = new int[numPerso];
            StringBuilder[] salidas = new StringBuilder[numPerso];
            
            for (int i = 0; i < numPerso; i++) {
                sumas[i] = 0;
                salidas[i] = new StringBuilder();
            }
            
            for (int i = 0; i < numBilletes; i++) {
                int persona = i % numPerso;
                int billete = billetes.get(i);
                sumas[persona] += billete;
                salidas[persona].append(billete).append(" ");
            }
            
            for (int i = 0; i < numPerso; i++) {
                System.out.println(sumas[i] + ": " + salidas[i].toString().trim());
            }
            
            System.out.println("---");
            billetes.clear();
        }
        
        sc.close();
    }
}