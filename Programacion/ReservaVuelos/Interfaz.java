import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;

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
            if (capacidad <= 0) {
                System.out.println("La capacidad no puede ser menor que 0.");
            }else{
                insertVuelo = "INSERT INTO Vuelos (Numero_vuelo, origen, destino, Fecha, capacidad)" +
                " VALUES ( '" + Numero_vuelo + "' ,'" + origen + "' ,'" + destino + "' ,'" + Fecha + " " + hora+ "' ,'" + capacidad + "');";
                st.executeUpdate(insertVuelo);
                System.out.println("Vuelo "+Numero_vuelo+" añadido correctamente.");
            }
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
        int id_vuelo = -1;
        try {
            // Ejecutamos la consulta SQL y obtenemos el resultado en ResultSet
            ResultSet rs = st.executeQuery("SELECT * FROM Vuelos");
            HashMap<Integer, String> vuelos = new HashMap<>();
            // Recorremos los resultados obtenidos y mostramos sus campos
            while (rs.next()) {
                id_vuelo = rs.getInt("id_vuelo");
                String numero_vuelo = rs.getString("Numero_vuelo");
                String origen = rs.getString("origen");
                String destino = rs.getString("destino");
                String fecha = rs.getString("fecha");
                String capacidad = rs.getString("capacidad");

                System.out.println("id_vuelo: " + id_vuelo + ", Numero_vuelo: " + numero_vuelo + ", origen: " + origen
                        + ", destino: " + destino + ", fecha: " + fecha + ", capacidad: " + capacidad);
                vuelos.put(id_vuelo, numero_vuelo);
            }
            if (vuelos.isEmpty()) {
                return -1;
            }
            if (vuelos.size() == 1) {
                System.out.println("Solo hay un vuelo, lo seleccionamos automaticamente.");
                return id_vuelo;
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
        int id_pasajero = -1;
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
            if (pasajeros.isEmpty()) {
                return -1;
            }
            if (pasajeros.size() == 1) {
                System.out.println("Solo hay un pasajero, lo seleccionamos automaticamente.");
                return id_pasajero;
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

    public static int contarReservas(Statement st, int id_vuelo) {
        int numReservas = 0;
        try {
            String selectReservas = "SELECT COUNT(*) FROM Vuelos_Pasajeros WHERE id_vuelo = '"+id_vuelo+"';";
            ResultSet rs = st.executeQuery(selectReservas);
            if (rs.next()) {
                numReservas = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
        return numReservas;
    }

    public static int sabercapacidadvuelo(Statement st, int id_vuelo) {
        int capacidad = 0;
        try {
            String selectReservas = "SELECT capacidad FROM Vuelos WHERE id_vuelo = '"+id_vuelo+"';";
            ResultSet rs = st.executeQuery(selectReservas);
            if (rs.next()) {
                capacidad = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
        return capacidad;
    }

    public static void reservaVuelo(Statement st) {
        try {
            int id_vuelo = vuelos(st);
            if (id_vuelo == -1) {
                System.out.println("No hay vuelos añade uno antes");
            }else{
                if (contarReservas(st, id_vuelo) >= sabercapacidadvuelo(st, id_vuelo)) {
                    System.out.println("El vuelo esta completo");
                }else {
                    int id_pasajero = pasajeros(st);
                    if (id_pasajero == -1) {
                        System.out.println("No hay pasajeros añade uno antes");
                    }else {
                        String insertreservaVuelo;
                        System.out.print("n_asiento: ");
                        int n_asiento = sc.nextInt();
                        if (n_asiento <= 0) {
                            System.out.println("El numero de asiento no puede ser menor que 0.");
                        }else{
                            if (sabercapacidadvuelo(st, id_vuelo) < n_asiento) {
                                System.out.println("El numero de asiento no puede ser mayor que la capacidad del vuelo.");
                            }else{
                                insertreservaVuelo = "INSERT INTO Vuelos_Pasajeros (id_vuelo, id_pasajero, n_asiento)" +
                                    " VALUES ( '" + id_vuelo + "' ,'" + id_pasajero + "', '" + n_asiento + "');";
                                st.executeUpdate(insertreservaVuelo);
                                System.out.println("Pasajero " + id_pasajero + " añadido al vuelo id " + id_vuelo
                                        + " con numero de asientos " + n_asiento + " .");
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
    }

    public static int mostrarReservas(Statement st) {
        int id = -1;
        try {
            // Ejecutamos la consulta SQL y obtenemos el resultado en ResultSet
            ResultSet rs = st.executeQuery("SELECT * FROM Vuelos_Pasajeros");
            HashMap<Integer, String> Reservas = new HashMap<>();
            // Recorremos los resultados obtenidos y mostramos sus campos
            System.out.println("\nReservas: ");
            while (rs.next()) {
                id = rs.getInt("id");
                int id_vuelo = rs.getInt("id_vuelo");
                int id_pasajero = rs.getInt("id_pasajero");
                int n_asiento = rs.getInt("n_asiento");

                System.out.println("id: " + id + ", id_vuelo: " + id_vuelo + ", id_pasajero: " + id_pasajero
                        + ", n_asiento: " + n_asiento);

                Reservas.put(id, ""+n_asiento);
            }
            if (Reservas.isEmpty()) {
                return -1;
            }

            boolean esta = false;
            while (!esta) {
                System.out.print("Que reservas quieres modificar (id)  : ");
                id = sc.nextInt();
                sc.nextLine();
                if (Reservas.containsKey(id)) {
                    esta = true;
                } else {
                    System.out.println("El id de la reserva no es valido.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
        return id;
    }

    public static void mostrarReserva(Statement st, int id) {
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM Vuelos_Pasajeros WHERE id = " + id);
            if (rs.next()) {
                int id_vuelo = rs.getInt("id_vuelo");
                int id_pasajero = rs.getInt("id_pasajero");
                int n_asiento = rs.getInt("n_asiento");

                System.out.println("id: " + id + ", id_vuelo: " + id_vuelo + ", id_pasajero: " + id_pasajero
                        + ", n_asiento: " + n_asiento);
            }
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
    }

    public static void modificarReserva(Statement st) {
        try {
            int id = mostrarReservas(st);
            if (id == -1) {
                System.out.println("No hay reservas añade una antes");
            }else {
                String updateReserva = "";
                boolean opcvalid = false;
                int id_vuelo;
                int id_pasajero;
                int n_asiento;

                while (!opcvalid) {
                    System.out.println("1 : id_vuelo");
                    System.out.println("2 : id_pasajero");
                    System.out.println("3 : n_asiento");
                    System.out.println("4 : todas");
                    System.out.print("que quieres modificar: ");
                    int opcion;
                    try {
                        opcion = sc.nextInt();
                        sc.nextLine();
                        switch (opcion) {
                            case 1:
                                System.out.print("id_vuelo que quieres: ");
                                id_vuelo = sc.nextInt();
                                sc.nextLine();
                                if (contarReservas(st, id_vuelo) >= sabercapacidadvuelo(st, id_vuelo)) {
                                    System.out.println("El vuelo esta completo");
                                }else{
                                    opcvalid = true;
                                    updateReserva = "UPDATE Vuelos_Pasajeros SET id_vuelo = " + id_vuelo + " WHERE id = " + id;
                                }
                                break;
                            case 2:
                                System.out.print("id_pasajero que quieres: ");
                                id_pasajero = sc.nextInt();
                                sc.nextLine();
                                opcvalid = true;
                                updateReserva = "UPDATE Vuelos_Pasajeros SET id_pasajero = " + id_pasajero + " WHERE id = " + id;
                                break;
                            case 3:
                                System.out.print("n_asiento que quieres: ");
                                n_asiento = sc.nextInt();
                                sc.nextLine();
                                updateReserva = "UPDATE Vuelos_Pasajeros SET n_asiento = " + n_asiento + " WHERE id = " + id;
                                opcvalid = true;
                                break;
                            case 4:
                                System.out.print("id_vuelo que quieres: ");
                                id_vuelo = sc.nextInt();
                                System.out.print("id_pasajero que quieres: ");
                                id_pasajero = sc.nextInt();
                                System.out.print("n_asiento que quieres: ");
                                n_asiento = sc.nextInt();
                                sc.nextLine();
                                updateReserva = "UPDATE Vuelos_Pasajeros SET id_vuelo = " + id_vuelo + ", id_pasajero = " + id_pasajero + ", n_asiento = " + n_asiento + " WHERE id = " + id;
                                opcvalid = true;
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Debes insertar un numero.");
                        sc.nextLine();
                    }
                }
                st.executeUpdate(updateReserva);
                System.out.println("Reserva modificada queda asi.");
                mostrarReserva(st, id);
            }

            

        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
    }

    public static void eliminarReserva(Statement st) {
        try {
            int id = mostrarReservas(st);
            if (id == -1) {
                System.out.println("No hay reservas añade una antes");
            }else {
                String eliminarReserva = "";
                eliminarReserva = "DELETE FROM Vuelos_Pasajeros WHERE id = " + id;
                st.executeUpdate(eliminarReserva);
                System.out.println("Reserva con id ("+id+") eliminada.");
            }
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // javac -cp :mysql-connector-j-8.3.0.jar *.java
        // java -cp :mysql-connector-j-8.3.0.jar Interfaz
        String NombreBaseDatos = "reservaVuelos";
        int opcion;
        //System.out.println("        ▄▄█▄▄");
        //System.out.println("    ▀▀▀██▀▀▀██▀▀▀");
        //System.out.println("▄▄▄▄▄▄▄███████▄▄▄▄▄▄▄");
        //System.out.println("  █▄█  ▀██▄██▀  █▄█");

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
                        modificarReserva(st);
                        break;
                    case 5:
                        eliminarReserva(st);
                        break;
                    case 6:
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                }
            } while (opcion != 6);

            sc.close();
            Conexion.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un numero.");
        }
    }
}
