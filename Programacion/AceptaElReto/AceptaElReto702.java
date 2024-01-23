package Programacion.AceptaElReto;

import java.util.Scanner;
import java.util.TreeMap;

public class AceptaElReto702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, String> mesCant = new TreeMap<String, String>();
        int dineroTotal = 0;
        String mes = "";
        String meses = "";
        String dinero = "";
        int casos = 0;
        String dia = "";
        String ord = "";
        int numeroInt = 0;
        dineroTotal = sc.nextInt();
        casos = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= casos; i++) {
            mes = sc.next();
            dinero = sc.next();
            sc.nextLine();
            // 12-31
            dia = mes.substring(0, mes.indexOf("-"));
            meses = mes.substring(mes.indexOf("-") + 1);
            ord = meses+"-"+dia;
            mesCant.put(ord, dinero);
        }
        int MesParaComprobar = 1;
        int primermes = 1;
        for (String mesesString : mesCant.keySet()) {
            String din = mesCant.get(mesesString);
            numeroInt = Integer.parseInt(din);
            int mesComp = Integer.parseInt(mesesString.substring(0, mesesString.indexOf("-")));

            if (primermes == mesComp) {
                dineroTotal = dineroTotal+numeroInt;
            }else{
                System.out.print(dineroTotal+" ");
                primermes = mesComp;
                MesParaComprobar++;
                for (int i = MesParaComprobar; i < mesComp; i++) {
                    MesParaComprobar++;
                    System.out.print(dineroTotal+" ");
                }
                dineroTotal = dineroTotal+numeroInt;
            }
        }
        for (int i = MesParaComprobar; i < 12; i++) {
            System.out.print(dineroTotal+" ");
        }
        System.out.println(dineroTotal);

        sc.close();
    }
}