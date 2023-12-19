import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio01 {
    public static void main(String[] args) {
        int veces;
        Scanner sc = new Scanner(System.in);
        String entrada = "";
        do {
            entrada = "";
            veces = sc.nextInt();
            for (int i = 0; i < veces; i++) {
                entrada += sc.next();
                entrada += " ";
            }
            //System.out.println(entrada);
            //System.err.println();
            // Ordenar la variable entrada
            String[] palabras = entrada.split(" ");
            Arrays.sort(palabras);

            // Contar la frecuencia de cada palabra
            int vecesrepe = 1;
            int vecesant = 0;
            String salida = "";
            for (int i = 1; i < palabras.length; i++) {
                if (palabras[i].equals(palabras[i - 1])) {
                    vecesrepe++;
                } else {
                    //System.out.println(palabras[i - 1] + ": " + vecesrepe);
                    vecesrepe = 1;
                }
                if (vecesrepe >= vecesant) {
                    if (vecesrepe == vecesant){
                        salida = "Empate";
                    }else{
                        salida  = palabras[i-1];
                        vecesant = vecesrepe;
                    }
                }
            }
            System.out.println(salida);
            veces--;
                
        }while (veces >= 0);
        sc.close();
    }
}