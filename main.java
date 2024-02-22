import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class Formulario {
    protected String id;
    protected String cliente;
    public String idClient;

    public Formulario(String id, String cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public abstract String[] obtenerDatos();

    public static String getTotalFormularios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotalFormularios'");
    }

    public String getidClient() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getidClient'");
    }

    public void cerrarReclamacion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cerrarReclamacion'");
    }
}

class PedidoDevolucion extends Formulario {
    protected String producto;
    protected double precio;

    public PedidoDevolucion(String id, String cliente, String producto, double precio) {
        super(id, cliente);
        this.producto = producto;
        this.precio = precio;
    }

    @Override
    public String[] obtenerDatos() {
        String[] datos = {
            "ID: " + id,
            "Cliente: " + cliente,
            "Producto: " + producto,
            "Precio: " + precio
        };
        return datos;
    }
}

class Reclamacion extends Formulario {
    protected String texto;
    protected boolean estadoAbierto;

    public Reclamacion(String id, String cliente, String texto) {
        super(id, cliente);
        this.texto = texto;
        this.estadoAbierto = true;
    }

    public void cerrarReclamacion() {
        estadoAbierto = false;
    }

    @Override
    public String[] obtenerDatos() {
        String estado = estadoAbierto ? "Abierta" : "Cerrada";
        String[] datos = {
            "ID: " + id,
            "Cliente: " + cliente,
            "Texto de la reclamación: " + texto,
            "Estado: " + estado
        };
        return datos;
    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Formulario> formularios = new HashMap<>();
    private static int contadorFormularios = 0;

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearPedido();
                    break;
                case 2:
                    crearDevolucion();
                    break;
                case 3:
                    crearReclamacion();
                    break;
                case 4:
                    cerrarReclamacion();
                    break;
                case 5:
                    imprimirFormularioPorID();
                    break;
                case 6:
                    imprimirTodasLasReclamaciones();
                    break;
                case 7:
                    imprimirTodosLosFormularios();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor ingrese un número válido.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1.- Crear pedido");
        System.out.println("2.- Crear devolucion");
        System.out.println("3.- Crear reclamacion");
        System.out.println("4.- Cerrar reclamación");
        System.out.println("5.- Imprimir formulario por ID");
        System.out.println("6.- Imprimir todas las reclamaciones");
        System.out.println("7.- Imprimir todos los formularios");
        System.out.println("0.- Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearPedido() {
        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Ingrese el producto: ");
        String producto = scanner.nextLine();
        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        String id = "PE" + (++contadorFormularios);
        PedidoDevolucion pedido = new PedidoDevolucion(id, cliente, producto, precio);
        formularios.put(id, pedido);
        System.out.println("Pedido creado con ID: " + id);
    }

    private static void crearDevolucion() {
        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Ingrese el producto: ");
        String producto = scanner.nextLine();
        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        String id = "DE" + (++contadorFormularios);
        PedidoDevolucion devolucion = new PedidoDevolucion(id, cliente, producto, precio);
        formularios.put(id, devolucion);
        System.out.println("Devolución creada con ID: " + id);
    }

    private static void crearReclamacion() {
        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Ingrese el texto de la reclamación: ");
        String texto = scanner.nextLine();
        String id = "RE" + (++contadorFormularios);
        Reclamacion reclamacion = new Reclamacion(id, cliente, texto);
        formularios.put(id, reclamacion);
        System.out.println("Reclamación creada con ID: " + id);
    }

    private static void cerrarReclamacion() {
        System.out.print("Ingrese el ID de la reclamación que desea cerrar: ");
        String id = scanner.nextLine();
        Formulario formulario = formularios.get(id);
        if (formulario instanceof Reclamacion) {
            Reclamacion reclamacion = (Reclamacion) formulario;
            reclamacion.cerrarReclamacion();
            System.out.println("Reclamación con ID " + id + " cerrada correctamente.");
        } else {
            System.out.println("El ID ingresado no corresponde a una reclamación.");
        }
    }

    private static void imprimirFormularioPorID() {
        System.out.print("Ingrese el ID del formulario que desea imprimir: ");
        String id = scanner.nextLine();
        Formulario formulario = formularios.get(id);
        if (formulario != null) {
            String[] datos = formulario.obtenerDatos();
            for (String dato : datos) {
                System.out.println(dato);
            }
        } else {
            System.out.println("No se encontró ningún formulario con el ID ingresado.");
        }
    }

    private static void imprimirTodasLasReclamaciones() {
        System.out.println("\nReclamaciones:");
        for (Formulario formulario : formularios.values()) {
            if (formulario instanceof Reclamacion) {
                String[] datos = formulario.obtenerDatos();
                for (String dato : datos) {
                    System.out.println(dato);
                }
                System.out.println();
            }
        }
    }

    private static void imprimirTodosLosFormularios() {
        System.out.println("\nTodos los formularios:");
        for (Formulario formulario : formularios.values()) {
            String[] datos = formulario.obtenerDatos();
            for (String dato : datos) {
                System.out.println(dato);
            }
            System.out.println();
        }
    }
}
