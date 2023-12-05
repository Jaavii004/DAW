import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repe;
        repe=sc.nextInt();
        String entrada;
        char primero;
        int numant;
        int vecesrepe;
        // Vamos a repitir tantas veces como nos ponga de repeticiones
        for (int i = 1; i <= repe; i++) {
            entrada=sc.next();
            primero = entrada.charAt(0);
            numant = primero;
            vecesrepe = 1;
            // vamos a mostrar el primer numero tal y como nos lo indicas
            System.out.print(primero+" ");
            // Vamos a entrar tantas veces como numeros nos pongan por si se te olvida alguno
            for (int j = 1; j < entrada.length(); j++) {
                //System.out.println("numant "+numant);
                // Vamos a comprobar si el numero a actual esd igual al anterior
                if (numant == entrada.charAt(j)) {
                    vecesrepe++;
                }else{
                    // Si no es igual lo mostramos y igualamos a 1 las veces encontradas
                    // y nos quedamos con el nuevo numero distinto
                    numant = entrada.charAt(j);
                    System.out.print(vecesrepe+" ");
                    vecesrepe = 1;
                }
            }
            // Ponemos la ultima aparicion con salto de linea
            System.out.println(vecesrepe);
        }
        sc.close();
    }
}
