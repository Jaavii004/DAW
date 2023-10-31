import java.util.Random;

public class Ejercicio01 {
    public static void main(String[] args) {
        Random random = new Random();
        String todosDados;
        int dado;
        dado = 0;
        int suma;
        suma = 0;
        todosDados = "";
        for (int i = 0; i < 3; i++) {
            dado += random.nextInt(6) + 1;
            todosDados += dado+" ";
            suma += dado;
        }
        System.out.println("Tirada de los dados: "+todosDados);
        System.out.println("Suma total: " + suma);
    }
}
