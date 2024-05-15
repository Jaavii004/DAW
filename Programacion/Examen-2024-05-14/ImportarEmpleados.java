import java.sql.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import java.sql.DriverManager;

public class ImportarEmpleados {
    public static void CrearTablaEmpleados(Statement st) {
        try {
            String CrearTabla = "CREATE TABLE Empleados (\n" + 
            "  `CodigoEmpleado` int NOT NULL,\n" +
            "  `Nombre` varchar(50) NOT NULL,\n" +
            "  `Apellido1` varchar(50) NOT NULL,\n" +
            "  `Apellido2` varchar(50) DEFAULT NULL,\n" +
            "  `Extension` varchar(10) NOT NULL,\n" +
            "  `Email` varchar(100) NOT NULL,\n" +
            "  `CodigoJefe` int DEFAULT NULL,\n" +
            "  `Puesto` varchar(50) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`CodigoEmpleado`),\n" +
            "  KEY `Empleados_EmpleadosFK` (`CodigoJefe`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
            st.executeUpdate(CrearTabla);
        } catch (SQLException e) {
            System.out.println("La tabla existe");
        }
    }

    public static void ImportarEmpleadosABD(Statement st) {
        try {
            File f = new File("Empleados.csv");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                try {
                    String[] emp = linea.split(",");
                    if (!linea.equals("CodigoEmpleado,Nombre,Apellido1,Apellido2,Extension,Email,CodigoJefe,Puesto")) {
                        int CodigoEmpleado = Integer.parseInt(emp[0]);
                        String Nombre = emp[1];
                        String Apellido1 = emp[2];
                        String Apellido2 = emp[3];
                        int Extension = Integer.parseInt(emp[4]);
                        String Email = emp[5];
                        int CodigoJefe = Integer.parseInt(emp[6]);
                        String Puesto = emp[7];
                        String insert = "INSERT INTO Empleados (`CodigoEmpleado`,`Nombre`,`Apellido1`,`Apellido2`,`Extension`,`Email`,`CodigoJefe`,`Puesto`)\n" + //
                                                "VALUES"+
                                                "("+CodigoEmpleado+" ,'"+Nombre+"','"+Apellido1+"','"+Apellido2+"','"+Extension+"','"+Email+"',"+CodigoJefe+",'"+Puesto+"')";
                        st.executeUpdate(insert);
                    }
                } catch (SQLException e) {
                    System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
                }
                linea = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // javac -cp :mysql-connector-j-8.3.0.jar ImportarEmpleados.java
        // java -cp :mysql-connector-j-8.3.0.jar ImportarEmpleados
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/exdaw", "root", "dbrootpass");
            // Creamos un objeto para enviar sentencias SQL a la BD
            Statement st = con.createStatement();
            CrearTablaEmpleados(st);
            ImportarEmpleadosABD(st);
            System.out.println("Importacion Completada");
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
    }
}
