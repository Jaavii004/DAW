import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public void MostrarCli(Statement st) {
        try {
            String query = "SELECT * FROM Clientes;";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("CodigoCliente"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // javac -cp :mysql-connector-j-8.3.0.jar *.java
        // java -cp :mysql-connector-j-8.3.0.jar Interfaz
        String NombreBaseDatos = "exdaw";
        int opcion;

        try {
            Connection con = Conexion.getConnection(NombreBaseDatos);
            // Creamos un objeto para enviar sentencias SQL a la BD
            Statement st = con.createStatement();
            MostrarCli(st);

            sc.close();
            Conexion.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un numero.");
        }
    }
}