import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class Interfaz {
    public static Scanner sc = new Scanner(System.in);

    public static void altaVuelo(Statement st) {
        // Para vuelos
        String Numero_vuelo = "";
        String origen = "";
        String destino = "";
        String Fecha = "";
        String hora = "";
        int capacidad = 0;
        String insertVuelo = "";
        try {
            System.out.print("Numero vuelo: ");
            Numero_vuelo = sc.nextLine();
            System.out.print("origen: ");
            origen = sc.nextLine();
            System.out.print("destino: ");
            destino = sc.nextLine();
            System.out.print("Fecha (Con formato: 2024-03-23): ");
            Fecha = sc.nextLine();
            System.out.print("Hora (con formato 12:00): ");
            hora = sc.next();
            System.out.print("capacidad: ");
            capacidad = sc.nextInt();
            sc.nextLine();
            insertVuelo = "INSERT INTO Vuelos (Numero_vuelo, origen, destino, Fecha, capacidad)" +
                    " VALUES ( '" + Numero_vuelo + "' ,'" + origen + "' ,'" + destino + "' ,'" + Fecha + " " + hora
                    + "' ,'" + capacidad + "');";
            st.executeUpdate(insertVuelo);
            System.out.println("Vuelo " + Numero_vuelo + " añadido correctamente.");
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }

    }

    public static void altaPasajero(Statement st) {
        try {
            // Para Pasajero
            String numero_pasaporte;
            String nombre_pasajero;
            String insertPasajero;
            System.out.print("numero_pasaporte: ");
            numero_pasaporte = sc.nextLine();
            System.out.print("nombre_pasajero: ");
            nombre_pasajero = sc.nextLine();
            insertPasajero = "INSERT INTO Pasajeros (numero_pasaporte, nombre_pasajero)" +
                    " VALUES ( '" + numero_pasaporte + "' ,'" + nombre_pasajero + "');";
            st.executeUpdate(insertPasajero);
            System.out.println(
                    "Pasajero " + nombre_pasajero + " insertado con numero de pasaporte " + numero_pasaporte + ".");
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
    }

    public static int vuelos(Statement st) {
        int id_vuelo = 0;
        try {
            // Ejecutamos la consulta SQL y obtenemos el resultado en ResultSet
            ResultSet rs = st.executeQuery("SELECT * FROM Vuelos");
            HashMap<Integer, String> vuelos = new HashMap<>();
            // Recorremos los resultados obtenidos y mostramos sus campos
            while (rs.next()) {
                int idvuelo = rs.getInt("id_vuelo");
                String numero_vuelo = rs.getString("Numero_vuelo");
                String origen = rs.getString("origen");
                String destino = rs.getString("destino");
                String fecha = rs.getString("fecha");
                String capacidad = rs.getString("capacidad");

                System.out.println("id_vuelo: " + idvuelo + ", Numero_vuelo: " + numero_vuelo + ", origen: " + origen
                        + ", destino: " + destino + ", fecha: " + fecha + ", capacidad: " + capacidad);
                vuelos.put(idvuelo, numero_vuelo);
            }

            boolean esta = false;
            while (!esta) {
                System.out.print("que vuelo quieres (id_vuelo)  : ");
                id_vuelo = sc.nextInt();
                sc.nextLine();
                if (vuelos.containsKey(id_vuelo)) {
                    esta = true;
                } else {
                    System.out.println("El id vuelo no es valido.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
        return id_vuelo;
    }

    public static int pasajeros(Statement st) {
        int id_pasajero = 0;
        try {
            // Ejecutamos la consulta SQL y obtenemos el resultado en ResultSet
            ResultSet rs = st.executeQuery("SELECT * FROM Pasajeros");
            HashMap<Integer, String> pasajeros = new HashMap<>();
            // Recorremos los resultados obtenidos y mostramos sus campos
            System.out.println("\nPasajeros: ");
            while (rs.next()) {
                id_pasajero = rs.getInt("id_pasajero");
                String numero_pasaporte = rs.getString("numero_pasaporte");
                String nombre_pasajero = rs.getString("nombre_pasajero");

                System.out.println("id_pasajero: " + id_pasajero + ", numero_pasaporte: " + numero_pasaporte
                        + ", nombre_pasajero: " + nombre_pasajero);
                pasajeros.put(id_pasajero, numero_pasaporte);
            }

            boolean esta = false;
            while (!esta) {
                System.out.print("que pasajero quieres (id_pasajero)  : ");
                id_pasajero = sc.nextInt();
                sc.nextLine();
                if (pasajeros.containsKey(id_pasajero)) {
                    esta = true;
                } else {
                    System.out.println("El id pasajero no es valido.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
        return id_pasajero;
    }

    public static void reservaVuelo(Statement st) {
        try {
            int id_vuelo = vuelos(st);
            int id_pasajero = pasajeros(st);
            String insertreservaVuelo;
            System.out.print("n_asientos: ");
            int n_asiento = sc.nextInt();
            insertreservaVuelo = "INSERT INTO Vuelos_Pasajeros (id_vuelo, id_pasajero, n_asiento)" +
                    " VALUES ( '" + id_vuelo + "' ,'" + id_pasajero + "', '" + n_asiento + "');";
            st.executeUpdate(insertreservaVuelo);
            System.out.println("Pasajero " + id_pasajero + " añadido al vuelo id " + id_vuelo
                    + " con numero de asientos " + n_asiento + " .");
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
    }

    public static int mostrarReservas(Statement st) {
        int id_pasajero = 0;
        try {
            // Ejecutamos la consulta SQL y obtenemos el resultado en ResultSet
            ResultSet rs = st.executeQuery("SELECT * FROM Vuelos_Pasajeros");
            HashMap<Integer, String> Vuelos_Pasajeros = new HashMap<>();
            // Recorremos los resultados obtenidos y mostramos sus campos
            System.out.println("\nVuelos_Pasajeros: ");
            while (rs.next()) {
                id_pasajero = rs.getInt("id_pasajero");
                String numero_pasaporte = rs.getString("numero_pasaporte");
                String nombre_pasajero = rs.getString("nombre_pasajero");

                System.out.println("id_pasajero: " + id_pasajero + ", numero_pasaporte: " + numero_pasaporte
                        + ", nombre_pasajero: " + nombre_pasajero);

                Vuelos_Pasajeros.put(id_pasajero, numero_pasaporte);
            }

            boolean esta = false;
            while (!esta) {
                System.out.print("que pasajero quieres (id_pasajero)  : ");
                id_pasajero = sc.nextInt();
                sc.nextLine();
                if (Vuelos_Pasajeros.containsKey(id_pasajero)) {
                    esta = true;
                } else {
                    System.out.println("El id pasajero no es valido.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
        return id_pasajero;
    }

    public static void modificarReserva(Statement st) {
        try {
            int id_vuelo = vuelos(st);
            int id_pasajero = pasajeros(st);
            String insertreservaVuelo;
            System.out.print("n_vuelos: ");
            int n_asiento = sc.nextInt();
            insertreservaVuelo = "INSERT INTO Vuelos_Pasajeros (id_vuelo, id_pasajero, n_asiento)" +
                    " VALUES ( '" + id_vuelo + "' ,'" + id_pasajero + "', '" + n_asiento + "');";
            st.executeUpdate(insertreservaVuelo);
            System.out.println("Pasajero " + id_pasajero + " añadido al vuelo id " + id_vuelo + " con numero de asiento"
                    + n_asiento + " .");
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // javac -cp :mysql-connector-j-8.3.0.jar *.java
        // java -cp :mysql-connector-j-8.3.0.jar Interfaz
        String NombreBaseDatos = "reservaVuelos";
        int opcion;

        try {
            Connection con = Conexion.getConnection(NombreBaseDatos);
            // Creamos un objeto para enviar sentencias SQL a la BD
            Statement st = con.createStatement();

            do {
                System.out.println("1. Alta Vuelo");
                System.out.println("2. Alta Pasajero");
                System.out.println("3. Reserva Vuelo");
                System.out.println("4. Modificar reserva");
                System.out.println("5. Baja reserva");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        altaVuelo(st);
                        break;
                    case 2:
                        altaPasajero(st);
                        break;
                    case 3:
                        reservaVuelo(st);
                        break;
                    case 4:
                        // modificar reserva
                        break;
                    case 5:
                        // baja de reserva
                        break;
                    case 6:
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                }
            } while (opcion != 6);

            // Ejecutamos la consulta SQL y obtenemos el resultado en ResultSet
            // ResultSet rs = st.executeQuery("SELECT * FROM Vuelos");
            //// Recorremos los resultados obtenidos y mostramos sus campos
            // while (rs.next()) {
            // String nombre = rs.getString("NOM");
            // int edad = rs.getInt("CLIENT_COD");
            // System.out.println(nombre + ": " + edad);
            // }
            sc.close();
            Conexion.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}