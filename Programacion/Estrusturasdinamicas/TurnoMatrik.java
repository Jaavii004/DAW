package Programacion.Estrusturasdinamicas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TurnoMatrik {
    public static void MostrarMenu() {
        System.out.println("1. Nuevo cliente ha entrado");
        System.out.println("2. Atender al siguiente cliente");
        System.out.println("3. Mostrar cola actual");
        System.out.println("0. Salir");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> clientes = new LinkedList<String>();
        int opcion = 6;
        String client = "";
        int delante = 0;
        while (opcion != 0) {
            MostrarMenu();
            System.out.print(": ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.println("Nombre cliente nuevo");
                    client = sc.nextLine();
                    delante = clientes.size();
                    System.out.println("Hay "+delante+" clientes delante");
                    clientes.add(client);
                    break;
                case 2:
                    if (clientes.size() == 0) {
                        System.out.println("No tenemos clientes");
                    }else{
                        System.out.println("Vamos a atender a "+clientes.poll());
                    }
                    break;
                case 0:
                    System.out.println("Salimos");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
        sc.close();
    }
}
