import java.util.Scanner;
public class AceptaElReto117 {
    public static void main(String[] arg) {
        int NumAlt;
        String nombre;
        String muestreo = "";
        String nombresolo;
        Scanner sc = new Scanner(System.in);
        NumAlt = sc.nextInt();
        nombre = sc.nextLine();
        for (int i = 0; i < NumAlt; i++) {
            nombre = sc.nextLine();
            String[] partes = nombre.split(" ");
            nombresolo =  partes[1];
            muestreo += "Hola, "+nombresolo+".\n";
        }
        System.out.print(muestreo);
    }
}
