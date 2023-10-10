import java.util.Scanner;

public class dowhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
        System.out.print("Enter a number: ");
        num = sc.nextInt();
        System.out.println("El numero es: " + num);
        } while (num != 0);
    
    }
}
