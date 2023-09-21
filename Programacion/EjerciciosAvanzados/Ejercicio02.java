import java.util.Scanner;
class Ejercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        double altura;
        double peso;
        double indice;
        System.out.print("Altura (Metros): ");
        altura = sc.nextDouble();
        System.out.print("Peso: ");
        peso = sc.nextDouble();

        double elevado = Math.pow(altura, 2);
        indice = peso / elevado;
        indice =Math.rint(indice*1000)/1000;
        System.out.println("Su indice de masa corporal es "+indice);
    }
}