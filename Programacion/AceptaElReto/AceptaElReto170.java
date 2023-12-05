import java.util.Scanner;

public class AceptaElReto170 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int piedras;        
        int veces;
        do {
            piedras = sc.nextInt();
            if (piedras != 0) {
                veces = 1;
                while (piedras >= veces) {
                    piedras -= veces;
                    veces++;
                }
                veces--;
                System.out.println(veces+" "+piedras);
                piedras=1;
            }
        } while (piedras != 0);
        sc.close();
    }
}