import lib.Tiempo;

public class PruebaTiempo {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        Tiempo tiempo1 = new Tiempo();
        System.out.println("Tiempo1: " + tiempo1);//"0h 0m 0s"

        Tiempo tiempo2 = new Tiempo(2, 45, 80);
        System.out.println("Tiempo2: " + tiempo2);//"2h 46m 20s"

        
        Tiempo tiempoprue = new Tiempo(2, 23, 25);
        System.out.println("Tiempoprue: "+tiempoprue);
        tiempoprue.suma(tiempo1);
        System.out.println("Tiempoprue + Tiempo1");
        tiempo1.suma(1, 30, 45);
        System.out.println("Tiempo1 después de suma: " + tiempo1);//"1h 30m 45s"



        tiempo2.resta(0, 15, 30);
        System.out.println("Tiempo2 después de resta: " + tiempo2);//"2h 30m 50s"

        tiempo2.resta(2, 0, 0);
        System.out.println("Tiempo2 después de resta: " + tiempo2);//"0h 0m 0s"

        Tiempo tiempo3 = new Tiempo(1, 30, 45);
        System.out.println("Tiempo3: "+tiempo3);//"1h 30m 35s"
        tiempo3.resta(0, 45, 61);
        System.out.println("Tiempo3 después de resta: " + tiempo3);//"0h 44m 45s"
    }
}