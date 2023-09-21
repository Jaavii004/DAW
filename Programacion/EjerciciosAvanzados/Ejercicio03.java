import java.util.*;
class Ejercicio03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        double a;
        double b;
        double c;
        double x;
        double x2;
        double resul;
        System.out.print("a = ");
        a = sc.nextDouble();
        System.out.print("b = ");
        b = sc.nextDouble();
        System.out.print("c = ");
        c = sc.nextDouble();
        resul = Math.pow(b, 2);
        resul = resul - 4 * a * c;
        resul = Math.sqrt(resul);
        x = (-b + resul)/ (2 * a);
        x2 = (-b - resul)/ (2 * a);

        System.out.println("x = "+x);
        System.out.println("x2 = "+x2);

    }
}