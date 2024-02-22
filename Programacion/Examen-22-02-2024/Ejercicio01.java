import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Formulario> formulariosList = new ArrayList<Formulario>();
        
        int opcion;
        String NomClient;
        String producto;
        double Precio;

        String Texto;
        String ID;
        do {
            System.out.println("\nMenú:");
            System.out.println("1.- Crear pedido");
            System.out.println("2.- Crear devolucion");
            System.out.println("3.- Crear reclamacion");
            System.out.println("4.- Cerrar reclamación");
            System.out.println("5.- Imprimir formulario por ID");
            System.out.println("6.- Imprimir todas las reclamaciones");
            System.out.println("7.- Imprimir todos los formularios");
            System.out.println("0.- Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 0:
                    System.out.println("Salir");
                    break;
                case 1:
                    System.out.print("Nombre cliente: ");
                    NomClient = sc.nextLine();
                    System.out.print("Producto: ");
                    producto = sc.nextLine();
                    System.out.print("Precio: ");
                    Precio = sc.nextDouble();
                    Formulario Pedido = new Pedido(NomClient, producto, Precio);
                    //listaFormularios.put(Pedido.getidClient(), Pedido);
                    formulariosList.add(Pedido);
                    
                    System.out.println("ID Formulario: "+Pedido.getidClient());
                    break;
                case 2:
                    System.out.print("Nombre cliente: ");
                    NomClient = sc.nextLine();
                    System.out.print("Producto: ");
                    producto = sc.nextLine();
                    System.out.print("Precio: ");
                    Precio = sc.nextDouble();
                    Formulario Devolucion = new Devolucion(NomClient, producto, Precio);
                    //listaFormularios.put(Devolucion.getidClient(), Devolucion);
                    formulariosList.add(Devolucion);
                    System.out.println("ID Formulario: "+Devolucion.getidClient());
                    break;
                case 3:
                    System.out.print("Nombre cliente: ");
                    NomClient = sc.nextLine();
                    System.out.print("Texto: ");
                    Texto = sc.nextLine();
                    Formulario Reclamacion = new Reclamacion(NomClient, Texto);
                    // listaFormularios.put(Reclamacion.getidClient(), Reclamacion);
                    formulariosList.add(Reclamacion);
                    System.out.println("ID Formulario: "+Reclamacion.getidClient());
                    break;
                case 4:
                    System.out.print("ID: ");
                    ID = sc.nextLine();
                    for (Formulario formulario : formulariosList) {
                        if (formulario.getidClient().equals(ID)) {
                            if (formulario.getidClient().contains("RE")) {
                                Reclamacion reclamacion = (Reclamacion) formulario;
                                reclamacion.CerrarReclamacion();
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.print("ID: ");
                    ID = sc.nextLine();
                    System.out.println();
                    for (Formulario formulario : formulariosList) {
                        if (formulario.getidClient().equals(ID)) {
                            System.out.println(formulario.toString());
                        }
                    }
                    break;
                case 6:
                    System.out.println();
                    for (Formulario formulario : formulariosList) {
                        if (formulario.getidClient().contains("RE")) {
                            System.out.println(formulario.toString());
                            System.out.println();
                        }
                    }
                    break;
                case 7:
                    for (Formulario formulario : formulariosList) {
                        System.out.println(formulario.toString());
                        System.out.println();
                    }
                    break;
                
                default:
                    System.out.println("Repetimos");
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }
}