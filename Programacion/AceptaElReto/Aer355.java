import java.util.Scanner;
public class Aer355 {
    public static void main(String[] arg) {
        int NumAlt;
        int anio;
        String muestreo = "";
        Scanner sc = new Scanner(System.in);
        NumAlt = sc.nextInt();
        for (int i = 1; i <= NumAlt; i++) {
            do{ 
                anio = sc.nextInt();
            }while (anio <= 1581 || anio > 100000);
            if ((anio % 4 == 0) && (anio % 100 != 0 || anio % 400 == 0)){
                muestreo += "29";
                muestreo += "\n";
            }else{
                muestreo += "28";
                muestreo += "\n";
            }
        }
        System.out.print(muestreo);
    }
}