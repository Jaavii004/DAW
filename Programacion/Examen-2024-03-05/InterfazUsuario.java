import java.util.ArrayList;
import java.util.Scanner;

public class InterfazUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String referencia = "";
        int metroscubicos = 0;
        while (true) {
            try {
                boolean vuelve = false;
                while (!vuelve) {
                    System.out.print("Referencia: ");
                    referencia = sc.nextLine();
                    vuelve = Calculos.existe(referencia);
                }
                System.out.print("m3: ");
                metroscubicos = sc.nextInt();
                sc.nextLine();
                ArrayList<String> salida = Calculos.calcular(referencia,metroscubicos);
                for (String calculos : salida) {
                    System.out.println(calculos);
                }
                System.out.println();
            } catch (Exception e) {
                if (e.getMessage() == null) {
                    System.out.println("Solo numeros enteros");
                    sc.nextLine();
                }else{
                    System.out.println(e.getMessage());
                }
                
            }
        }
    }
}