package Programacion.AceptaElReto;

import java.util.Scanner;

public class AceptaElReto702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dineroTotal = 0;
        int casos = 0;
        dineroTotal = sc.nextInt();
        casos = sc.nextInt();
        sc.nextLine();
        System.out.println(dineroTotal);
        String mes = sc.next();
        String dinero = sc.next();
        sc.nextLine();
        for (int i = 1; i < casos; i++) {
            mes = sc.next();
            dinero = sc.next();
            sc.nextLine();
            

            if (dinero.contains("+") | dinero.contains("-") ) {
                System.out.println(" "+dinero);
            }
        }
        sc.close();
    }
}
