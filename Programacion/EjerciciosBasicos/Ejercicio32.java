public class Ejercicio32 {
    public static void main(String[] args) {
        double x = 88;
        double y = 3.5;
        double z = -5.2;
        double resulta = x + y + z;
        double resultb = 2*y+3*(x-z);
        double resultc = x/y;
        double resultd = x % y; 
        double resulte = x / (y + z); 
        double resultf = x * (y % z); 
        double resultg = 3 * x - z - 2 * x; 
        double resulth = 2 * x / 5 % y; 
        double resulti = x - y - z * 2; 

        System.out.println("x + y + z = "+resulta);
        System.out.println("2 * y + 3 * (x - z) = "+resultb);
        System.out.println("x / y = "+resultc);
        System.out.println("x % y = "+resultd);
        System.out.println("x / (y + z) = "+resulte);
        System.out.println("x * (y % z) = "+resultf);
        System.out.println("3 * x - z - 2 * x = "+resultg);
        System.out.println("2 * x / 5 % y = "+resulth);
        System.out.println("x - y - z * 2 = "+resulti);
    }
}
