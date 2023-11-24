import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AceptaElReto210 {
    public static boolean esPrimo(int numero) {
        boolean resultado;
        int numprim = 0;
        int divi = 1;
        if (numero % 1 != 0) {
            divi = numero+1;
            resultado = false;
        }
        while (divi <= numero) {
            if (numero % divi == 0) {
                numprim++;
            }
            divi++;
        }
        if (numprim == 2) {
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }

    public static int anteriorPrimo(int numero) {
        do {
            numero--;
        } while (!esPrimo(numero));
        return numero;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num;
        char letra;
        int contador = 0;
        num = Integer.parseInt(br.readLine());
        do {
            String palabra = br.readLine();
            int suma = 0;
            // Recorrer todas las letras de la palabra y sumarlas
            for (int i = 0; i < palabra.length(); i++) {
                letra = palabra.charAt(i);
                suma += letra;
            }
            int antprim = anteriorPrimo(suma);
            System.out.println(antprim);
            contador++;
        } while (contador < num);
        br.close();
    }
}