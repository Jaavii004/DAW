import java.util.Scanner;

public class AceptaElReto170 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int piedras;
        int sacadas = 0;
        piedras = sc.nextInt();
        int j = 0;
        int sobran = 0;
        while (sacadas < piedras) {
            j = j+1;
            for (int i = 0; i <= j;i++) {
                if (sacadas >= piedras ) {

                    i=j+1;
                }else {
                   System.out.print("*");

                    sacadas++;
                }
            }
            if (sacadas >= piedras ) {
//                j--;
  //              sobran--;
                    sobran=sacadas-piedras;

                System.out.println("Sobran "+sobran);
                System.out.println("J "+j);

            }

            System.out.println("");
            
        }
        sc.close();
    }
}
