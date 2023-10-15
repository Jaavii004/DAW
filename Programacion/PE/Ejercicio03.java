import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int numeroAbsoluto;
        int cantidadDigitos = 0;
        String numeroComoCadena;

        System.out.print("Ingrese un número entero de hasta 6 dígitos: ");
        numero = sc.nextInt();
        numeroComoCadena = Integer.toString(numero);

        for (char digito : numeroComoCadena.toCharArray()) {
            cantidadDigitos++;
        }

        if (cantidadDigitos < 7){
            System.out.println("El número "+numero+" tiene "+cantidadDigitos+" dígitos.");
        }else{
            System.out.println("El número "+numero+" tiene un numero de digitos incorrecto");
        }

    }
}
