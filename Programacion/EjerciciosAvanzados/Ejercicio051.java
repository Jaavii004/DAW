import java.util.*;
class Ejercicio051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int numicazuela;
        int numihuevos;

        System.out.print("Cuantos huevos caben en la cazuela? ");
        numicazuela = sc.nextInt();

        System.out.print("Cuantos huevos quieres cocer? ");
        numihuevos = sc.nextInt();

        System.out.println("En la cazuela caben "+numicazuela+" huevos.");
        System.out.println("Quieres cocer "+numihuevos+" huevos.");

        // Le vamos a restar uno para que al dividir la division no de el numero exacto
        // y poder calcular con un resulrtado al anterior y para que la division suma uno y puedas ver el resultado correctamente
        // Por ejempplo si caben 5 huevos y y tienes 10 pues le restas uno para que valga 14 y la division de 2.9 asi que como es int da 2 y al multiplicar de 20
        int suma = (numicazuela + numihuevos) - 1;

        int divi = suma / numicazuela;
        int resu = divi * 10;
        System.out.println("Tardaras en cocer todos los huevos "+resu+" minutos");
        
    }
}
