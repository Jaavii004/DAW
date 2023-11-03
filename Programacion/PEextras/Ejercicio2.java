import java.util.Scanner;

public class CalculadoraRPN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = true;
        String input = "";
        int vueltas = 0;
	String C = "";
        String D = "";	    
        while (salir) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
	    
	    if (vueltas == 2){
                C = D;
            }
	    D = input;
            System.out.print("D: "+input);
	    
            
            System.out.print("\nC: "+C);

            System.out.print("\nB: ");

            System.out.print("\nA: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("Q")) {
                salir = false;
            } else {

            }
            vueltas++;
	    
        }

        System.out.println("Saliendo de la calculadora RPN.");
    }
}
