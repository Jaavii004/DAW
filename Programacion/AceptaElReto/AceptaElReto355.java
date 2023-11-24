import java.util.Scanner;
public class AceptaElReto355 {
    public static void main(String[] arg) {
        int NumAlt, anio;
        String muestreo = "";
        Scanner sc = new Scanner(System.in);
        NumAlt = sc.nextInt();
        for (int i = 1; i <= NumAlt; i++) {
            anio = sc.nextInt();
            if (anio % 4 == 0){
                if (anio % 100 == 0){
                    if (anio % 400 == 0){
                        muestreo+="29\n";
                    }else{
                        muestreo+="28\n";
                    }
                }else{
                    muestreo+="29\n";
                }
            }else{
                muestreo+="28\n";
            }
        }
        System.out.print(muestreo);
        sc.close();
    }
}