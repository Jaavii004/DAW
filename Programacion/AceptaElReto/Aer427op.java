import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aer427op {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int NumAlt = Integer.parseInt(br.readLine());
        StringBuilder muestreo = new StringBuilder();
        
        for (int i = 1; i <= NumAlt; i++) {
            String entrada1 = br.readLine();
            String entrada2 = br.readLine();
            
            if (entrada1.equals("Luke") && entrada2.equals("padre")) {
                muestreo.append("TOP SECRET\n");
            } else {
                muestreo.append(entrada1 + ", yo soy tu " + entrada2 + "\n");
            }
        }
        
        System.out.print(muestreo);
    }
}
