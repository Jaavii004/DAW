import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AceptaElReto355_v1 {
    public static void main(String[] args) throws IOException {
        int NumAlt;
        StringBuilder muestreo = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        NumAlt = Integer.parseInt(br.readLine());

        for (int i = 0; i < NumAlt; i++) {
            int anio = Integer.parseInt(br.readLine());
            boolean esBisiesto = (anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0));

            if (esBisiesto) {
                muestreo.append("29\n");
            } else {
                muestreo.append("28\n");
            }
        }

        System.out.print(muestreo);
    }
}
