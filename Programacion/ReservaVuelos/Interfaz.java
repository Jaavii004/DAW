import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
            insertVuelo = "INSERT INTO Vuelos (Numero_vuelo, origen, destino, Fecha, capacidad)"+
            " VALUES ( '"+Numero_vuelo+"' ,'" +origen+"' ,'"+destino +"' ,'"+Fecha+" "+hora+"' ,'"+capacidad+"');";
            st.executeUpdate(insertVuelo);
            System.out.println("Vuelo "+Numero_vuelo+" añadido correctamente.");
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
       
    }
    public static void main(String[] args) {
        // javac -cp :mysql-connector-j-8.3.0.jar *.java
        // java -cp :mysql-connector-j-8.3.0.jar Interfaz
        String NombreBaseDatos = "reservaVuelos";
        int opcion;

        // Para Pasajero
        String numero_pasaporte;
        String nombre_pasajero;
        String insertPasajero;
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
                        System.out.print("numero_pasaporte: ");
                        numero_pasaporte = sc.nextLine();
                        System.out.print("nombre_pasajero: ");
                        nombre_pasajero = sc.nextLine();
                        insertPasajero = "INSERT INTO Pasajeros (numero_pasaporte, nombre_pasajero)"+
                        " VALUES ( '"+numero_pasaporte+"' ,'"+nombre_pasajero+"');";
                        st.executeUpdate(insertPasajero);
                        System.out.println("Pasajero "+nombre_pasajero+" insertado con numero de pasaporte "+numero_pasaporte+".");
                        break;
                    case 3:
                        // Lógica para la reserva de vuelo
                        break;
                    case 4:
                        // Lógica para modificar reserva
                        break;
                    case 5:
                        // Lógica para la baja de reserva
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
            //ResultSet rs = st.executeQuery("SELECT * FROM Vuelos");
            //// Recorremos los resultados obtenidos y mostramos sus campos
            //while (rs.next()) {
            //    String nombre = rs.getString("NOM");
            //    int edad = rs.getInt("CLIENT_COD");
            //    System.out.println(nombre + ": " + edad);
            //}
            sc.close();
            Conexion.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}