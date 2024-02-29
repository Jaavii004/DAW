import java.util.Scanner;

public class Division1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("numerador: ");
            int num = sc.nextInt();
            System.out.print("denominador: ");
            int dem = sc.nextInt();
            System.out.println("Resultado de la division: " + (num / dem));
        } catch (Exception e) {
            System.out.println("Problemas con la division");
        }
        sc.close();
    }
}
