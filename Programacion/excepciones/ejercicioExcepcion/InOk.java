import java.util.Scanner;

public class InOk {
    private static Scanner sc = new Scanner(System.in);
    public static final String[] COMPOSITORES = {"Bach", "Haydn", "Mozart", "Beethoven", "Brahms", "Mahler", "Bartok"};
    private static int num;
    private static double numdouble;

    public static void LeeInt(){
        try {
            System.out.print("LeeInt(): ");
            sc.nextInt();
        } catch (Exception e) {
            System.out.println("Error no es un numero entero ");
            sc.nextLine();
        }
    }

    public static void LeeIntPos(){
        try {
            System.out.print("LeeIntPos(): ");
            sc.nextLine();
            num = sc.nextInt();
            if (num < 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error numero no positivo");
            sc.nextLine();
        }
    }

    public static void LeeIntRango(){
        System.out.print("LeeIntRango(): ");

        try {
            num = sc.nextInt();
            if ((num > 100) || (num < 0)) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Número fuera del rango [0,100]");
            sc.nextLine();
        }
    }

    public static void LeeDou(){
        try {
            numdouble = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("Error no es un numero real");
            sc.nextLine();
        }
    }

    public static void LeeDouRango(){
        try {
            System.out.print("LeeDouRango(): ");
            LeeDou();
            if (numdouble < 0 || numdouble > 100) {
                throw new Exception("Número fuera del rango (0, 100)");
            }
        } catch (Exception e) {
            System.out.println("Número fuera del rango [0,100]");
            sc.nextLine();
        }
    }

    public static void LeeElementosString(){
        String compositor = "";
        int cont = 0;
        int encontrado = -1;
        try {
            System.out.print("LeeElementosString(): ");
            compositor = sc.next();
            for (String compositoFor : COMPOSITORES) {
                if (compositor.equals(compositoFor)) {
                    encontrado = cont;
                }
                cont++;
            }
            if (encontrado == -1) {
                throw new ElementoNoExiste("El compositor no esta en la lista");
            }
            System.out.println("Me encuentas en la posicion "+encontrado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        }
    }
    public static void main(String[] args) {
        LeeInt();
        LeeIntPos();
        LeeIntRango();
        System.out.print("LeeDou(): ");
        LeeDou();
        LeeDouRango();
        LeeElementosString();
    }
}
