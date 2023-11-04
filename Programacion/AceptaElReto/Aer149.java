import java.util.Scanner;

public class Aer149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numAltera;
        int numToros;
        int numAntVel;
        int velToros  = 0;
        int masVel = 0;
        String muestreo = "";
        System.out.print("Numero de lineas: ");
        numAltera = sc.nextInt();
        for (int i = 0; i < numAltera; i++) {
            masVel = 0;
            numAntVel = 0;
            velToros = 0;
            System.out.print("Numero de toros: ");
            numToros = sc.nextInt();
            for (int j = 1; j <= numToros; j++) {
                numAntVel = velToros;
                System.out.print("Velocidad de los toros: ");
                velToros = sc.nextInt();
                if (numAntVel < velToros) {
                    masVel = velToros;
                }
            }
            muestreo += masVel;
            muestreo += "\n";
        }
        System.out.print(muestreo);
        
    }
}
