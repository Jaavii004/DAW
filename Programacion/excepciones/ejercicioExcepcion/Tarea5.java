import java.util.InputMismatchException;
import java.util.Scanner;

public class Tarea5 {
    public static int divide(int nume, int denom) throws ArithmeticException{
        if (denom == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return nume / denom;
    }
    public static void main(String[] args) throws ElementoNoCeros {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("numerador: ");
            int num = sc.nextInt();
            System.out.print("denominador: ");
            int dem = sc.nextInt();
            int result = divide(num, dem);
            System.out.println("Resultado de la division: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Ingrese un número entero valido.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Problemas con la division");
        }
        sc.close();
    }
}