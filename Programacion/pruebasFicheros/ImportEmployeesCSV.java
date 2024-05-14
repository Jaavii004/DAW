import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImportEmployeesCSV {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/exdaw";
        String user = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            createEmployeesTable(connection);
            readAndInsertCSVData(connection, "path/to/Empleados.csv");
        } catch (SQLException e) {
            System.err.println("Error connecting to the database");
            e.printStackTrace();
        }
    }

    private static void createEmployeesTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS empleados (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nombre VARCHAR(50)," +
                "apellidos VARCHAR(50)," +
                "email VARCHAR(50)," +
                "telefono VARCHAR(15)," +
                "fecha_nacimiento DATE," +
                "puesto VARCHAR(50)" +
                ")";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        }
    }

    private static void readAndInsertCSVData(Connection connection, String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length == 7) {
                    insertEmployee(connection, line[0], line[1], line[2], line[3], line[4], line[5]);
                } else {
                    System.err.println("Invalid CSV format: " + String.join(",", line));
                }
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading CSV file");
            e.printStackTrace();
        }
    }

    private static void insertEmployee(Connection connection, String nombre, String apellidos, String email,
                                       String telefono, String fecha_nacimiento, String puesto) {
        String sql = "INSERT INTO empleados (nombre, apellidos, email, telefono, fecha_nacimiento, puesto) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setString(3, email);
            statement.setString(4, telefono);
            statement.setDate(5, java.sql.Date.valueOf(fecha_nacimiento));
            statement.setString(6, puesto);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting employee");
            e.printStackTrace();
        }
    }
}