import java.util.Scanner;

public class PB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < T; i++) {
            String linea = scanner.nextLine();
            if (esCorrecta(linea)) {
                System.out.println("EQUILIBRADA");
            } else {
                System.out.println("ERROR");
            }
        }
    }
    
    private static boolean esCorrecta(String linea) {
        if (linea.length() < 4) {
            return false; 
        }
        
        int count = 0;
        for (char c : linea.toCharArray()) {
            if (c == '0') {
                count++;
            } else if (c == '1') {
                count--;
            }
        }
        
        String primerosDos = linea.substring(0, 2);
        String ultimosDos = linea.substring(linea.length() - 2);
        
        return count == 0 && primerosDos.equals(ultimosDos);
    }
}