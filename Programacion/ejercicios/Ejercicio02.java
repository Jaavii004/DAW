import funciones.FNumDAW;

public class Ejercicio02 {
    public static void main(String[] args) {
        int contador = 0;
        for (int i = 1000; i <= 9999; i++){
            if (FNumDAW.esCapicua(i)) {
                System.out.println(i+" es capicua.");
                contador++;
            }
        }
        System.out.println("El numero total de numeros capicua es: " + contador);
    }
}
