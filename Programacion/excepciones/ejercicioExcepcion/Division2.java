import java.util.InputMismatchException;
import java.util.Scanner;

public class Division2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("numerador: ");
            int num = sc.nextInt();
            System.out.print("denominador: ");
            int dem = sc.nextInt();
            System.out.println("Resultado de la division: " + (num / dem));
        } catch (InputMismatchException e) {
            System.out.println("Ingrese un número entero valido.");
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero.");
        } catch (Exception e) {
            System.out.println("Problemas con la division");
        }
    }
}