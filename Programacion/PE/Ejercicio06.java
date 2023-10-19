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
        do{
            System.out.print("Primer Dia: ");
            PrimDia = sc.nextInt();
        }while (PrimDia <= 0 || PrimDia > 7);

        do{
            System.out.print("Primera Hora: ");
            PrimHora = sc.nextInt();
        }while (PrimHora < 0 || PrimHora > 23);

        do{
            System.out.print("Segundo Dia: ");
            SegDia = sc.nextInt();
        }while (SegDia <= 0 || SegDia > 7);

        do{
            System.out.print("Segunda Hora: ");
            SegHora = sc.nextInt();
        }while (SegHora < 0 || SegHora > 23);

        Diahora = (SegDia - PrimDia)*24;
        Horas = SegHora - PrimHora;

        total = Diahora + Horas;

        System.out.println("El total es "+total+" horas.");
    }
}
