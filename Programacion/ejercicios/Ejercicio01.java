import funciones.FNumDAW;

public class Ejercicio01 {
    public static void main(String[] args) {
        int contador = 0;
        for (int i = 1; i <= 1000; i++){
            if (FNumDAW.esPrimo(i)) {
                System.out.println(i+" es primo.");
                contador++;
            }
        }
        System.out.println("El numero total de numeros primos es: " + contador);
    }
}
