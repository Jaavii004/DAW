import java.util.Scanner;
import java.util.TreeMap;

public class PE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cassos = sc.nextInt();

        TreeMap<Integer, String> participantes = new TreeMap<Integer, String>();

        for (int i = 0; i < cassos; i++) {
            int numero = sc.nextInt();
            String nombre = sc.next();
            if (participantes.containsKey(numero)) {
                participantes.put(numero, "NOT FOUND");
            } else {
                participantes.put(numero, nombre);
            }
        }

        for (String name : participantes.values()) {
            
            if (!name.equals("NOT FOUND")) {
                System.out.println(name);
                break;
            }
        }
        sc.close();
    }
}