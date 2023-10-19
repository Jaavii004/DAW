import java.util.Scanner;

public class Aer427 {
    public static void main(String[] arg) {
        int NumAlt;
        String muestreo = "";
        String entrada1;
        String entrada2;
        Scanner sc = new Scanner(System.in);
        NumAlt = sc.nextInt();
        entrada1 = sc.nextLine();
        for (int i = 1; i <= NumAlt; i++) {
            entrada1 = sc.nextLine();
            entrada2 = sc.nextLine();
            if ( entrada1.equals("Luke") && entrada2.equals("padre") ){
                muestreo += "TOP SECRET\n";
            }else{
                muestreo += (entrada1+", yo soy tu "+entrada2+"\n");
            }
        }
        System.out.print(muestreo);
    }
}
