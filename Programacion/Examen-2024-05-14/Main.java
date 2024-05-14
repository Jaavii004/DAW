import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;

public class Main {
    public static void MostrarCli(Statement st) {
        try {
            FileWriter fw = new FileWriter("./Clientes.csv");
            fw.write("CodigoCliente,NombreCliente,NombreContacto,ApellidoContacto,Telefono,Fax,LineaDireccion1,LineaDireccion2,Ciudad,Region,Pais,CodigoPostal,LimiteCredito\n");
            String query = "SELECT CodigoCliente, NombreCliente, NombreContacto, ApellidoContacto, Telefono, Fax, LineaDireccion1, LineaDireccion2, Ciudad, Region, Pais, CodigoPostal, LimiteCredito FROM clientes;";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("CodigoCliente: " + rs.getInt("CodigoCliente"));
                System.out.println("NombreCliente: " + rs.getString("NombreCliente"));
                System.out.println("NombreContacto: " + rs.getString("NombreContacto"));
                System.out.println("ApellidoContacto: " + rs.getString("ApellidoContacto"));
                System.out.println("Telefono: " + rs.getString("Telefono"));
                System.out.println("Fax: " + rs.getString("Fax"));
                System.out.println("LineaDireccion1: " + rs.getString("LineaDireccion1"));
                System.out.println("LineaDireccion2: " + rs.getString("LineaDireccion2"));
                System.out.println("Ciudad: " + rs.getString("Ciudad"));
                System.out.println("Region: " + rs.getString("Region"));
                System.out.println("Pais: " + rs.getString("Pais"));
                System.out.println("CodigoPostal: " + rs.getString("CodigoPostal"));
                System.out.println("LimiteCredito: " + rs.getDouble("LimiteCredito"));
                System.out.println("-----------------------------------------------------------");
                fw.write(rs.getInt("CodigoCliente") + "," +
                             rs.getString("NombreCliente") + "," +
                             rs.getString("NombreContacto") + "," +
                             rs.getString("ApellidoContacto") + "," +
                             rs.getString("Telefono") + "," +
                             rs.getString("Fax") + "," +
                             rs.getString("LineaDireccion1") + "," +
                             rs.getString("LineaDireccion2") + "," +
                             rs.getString("Ciudad") + "," +
                             rs.getString("Region") + "," +
                             rs.getString("Pais") + "," +
                             rs.getString("CodigoPostal") + "," +
                             rs.getDouble("LimiteCredito") + "\n");
            }
            fw.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch ( IOException o) {
            o.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // javac -cp :mysql-connector-j-8.3.0.jar *.java
        // java -cp :mysql-connector-j-8.3.0.jar Main
        String NombreBaseDatos = "exdaw";
        int opcion = 1;

        try {
            Connection con = Conexion.getConnection(NombreBaseDatos);
            // Creamos un objeto para enviar sentencias SQL a la BD
            Statement st = con.createStatement();
            MostrarCli(st);

            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

            //sc.close();
            Conexion.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un numero.");
        }
    }
}