import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio01 {
    
    public static void main(String[] args) {
        int veces;
        Scanner sc = new Scanner(System.in);
        veces = sc.nextInt();
        int vecesrepe = 0;
        for (int i = 0; i < veces; i++) {
            sc.nextLine();
            vecesrepe = 0;
            String entrada = sc.nextLine();
            String Striant = entrada.substring(0, entrada.indexOf(" ")); 
            String[] palabras = entrada.split(" ");
            Arrays.sort(palabras);
            String resultado = String.join(" ", palabras);
            
            for (int j = 1; j < entrada.length(); j++) {

                if (Striant.equals(entrada.substring(j, entrada.indexOf(" ")))) {
                    vecesrepe++;
                }else{
                    
                    Striant = entrada.substring(0, entrada.indexOf(" "));
                    
                    vecesrepe = 1;
                }
            }
            // Ponemos la ultima aparicion con salto de linea
            System.out.println(vecesrepe);

            
            System.out.println(resultado);
        }
    }
}
