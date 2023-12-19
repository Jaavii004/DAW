import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio01 {
    public static void main(String[] args) {
        int veces;
        Scanner sc = new Scanner(System.in);
        boolean EsNum = true;
        String entrada = "";
        do {
            entrada = "";
            veces = sc.nextInt();
            for (int i = 0; i < veces; i++) {
                entrada += sc.next();
                entrada += " ";
            }
            System.out.println(entrada);
            System.err.println();
            // Ordenar la variable entrada
            String[] palabras = entrada.split(" ");
            Arrays.sort(palabras);

            // Contar la frecuencia de cada palabra
            int vecesrepe = 1;
            for (int i = 1; i < palabras.length; i++) {
                if (palabras[i].equals(palabras[i - 1])) {
                    vecesrepe++;
                } else {
                    System.out.println(palabras[i - 1] + ": " + vecesrepe);
                    vecesrepe = 1;
                }
            }
            System.out.println(palabras[palabras.length - 1] + ": " + vecesrepe);


                
            //veces = sc.nextInt();
            //palabras = new String[veces];
            //combinedArray = new String[veces];
            //for (int i = 0; i <= veces; i++) {
            //    int rest = 0;
            //    sc.nextLine();
            //    String entrada = sc.nextLine();
            //    for (int j = 0; j <= entrada.length()-1; j++) {
            //        
            //        palabras[j] = entrada;
            //        rest++;
            //    }
            //    i+=rest;
            //    
            //}
            //// Ordenar el array palabras
            //String[] palabrasOrdenadas =  Arrays.sort(palabras);

            // Guardar el array ordenado en otro array llamado palabrasOrdenadas
            ////palabrasOrdenadas = Arrays.copyOf(palabras, palabras.length-1);
            //for (int i = 0; i < arrayPalabras.length; i++) {
            //    System.out.print(arrayPalabras[i]+"65");
            //}
            veces--;
                
        }while (veces >= 0);
        sc.close();
    }
}


//String Striant = entrada.substring(0, entrada.indexOf(" "));
                //System.out.println(entrada);
                //String[] palabras = entrada.split(" ");
                //entrada =  Arrays.sort(palabras);
                //for (int j = 1; j <= entrada.length(); j++) {
                //    if (Striant.equals(entrada.substring(j, entrada.indexOf(" ")))) {
                //        vecesrepe++;
                //    }else{
                //        Striant = entrada.substring(j, entrada.indexOf(" "));
                //        vecesrepe = 1;
                //    }
                //    rest++;
                //}
                //i+=rest;
                //System.out.println(vecesrepe);