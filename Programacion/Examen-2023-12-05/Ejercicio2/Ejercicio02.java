import lib.Cortesia;

public class Ejercicio02 {
    public static void main(String[] args) {
        String saludo = Cortesia.saludo("FR", "Javier");
        String despedida = Cortesia.despedida("FR");
        System.out.println(saludo);
        System.out.println(despedida);
    }
}
