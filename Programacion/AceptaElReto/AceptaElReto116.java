import java.util.Scanner;
public class AceptaElReto116 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner (System.in);
        int num;
        num = sc.nextInt();
        if(num >= 0 && num <= 5) {
            int i = 1;
            num++;
            while (num >= 0 && num <= 6) {
                if (i==num) {
                    num = 18;
                }
                if (i != 1) {
                    System.out.println("Hola mundo.");
                }
                i++;
            }
        }
    }
}