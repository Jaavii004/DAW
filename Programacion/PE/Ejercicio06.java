import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int PrimDia;
        int PrimHora;
        int SegDia;
        int SegHora;
        int Diahora;
        int Horas;
        int total;

        System.out.print("Primer Dia: ");
        PrimDia = sc.nextInt();
        System.out.print("Primera Hora: ");
        PrimHora = sc.nextInt();

        System.out.print("Segundo Dia: ");
        SegDia = sc.nextInt();
        System.out.print("Segunda Hora: ");
        SegHora = sc.nextInt();
        Diahora = (SegDia - PrimDia)*24;
        Horas = SegHora - PrimHora;

        total = Diahora + Horas;

        System.out.println("El total es "+total+" horas.");

    }
}
