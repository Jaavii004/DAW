import java.util.Scanner;

public class Eer01 {
    public static void main(String[] args) {
        int numrepe;
        int numale;
        String nummale;
        int sumamale;
        int carritos;
        Scanner sc = new Scanner(System.in);
        numrepe = sc.nextInt();

        for (int i = 1; i <= numrepe; i++) {
            sumamale = 0;
            carritos = 0;
            numale = sc.nextInt();
            sc.nextLine();
            nummale = sc.nextLine();
            String numsepa[] = nummale.split(" ");
            for (int j = 0; j < numale; j++) {
                String altern = numsepa[j];
                int number = Integer.parseInt(altern);
                sumamale += number;
                if (sumamale == 10) {
                    carritos += 1;
                    sumamale = 0;
                }
                if (sumamale > 10){
                    carritos += 1;
                    sumamale = number;
                }
                if (j == numale-1){
                    if (sumamale != 0){
                        carritos += 1;
                    }
                }
            }
            System.out.println(carritos);
        }
    }
}
