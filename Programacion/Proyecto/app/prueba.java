import java.sql.*;

public class prueba {
    // JDBC URL, usuario y contraseña de la base de datos
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/nombre_de_tu_base_de_datos";
    static final String USUARIO = "javier";
    static final String CONTRASEÑA = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USUARIO, CONTRASEÑA)) {
            // Consulta SQL
            String sql = "SELECT id_partido, fecha FROM Partidos WHERE fecha > CURDATE() AND resultado IS NULL";

            // Crear una declaración
            try (Statement stmt = conn.createStatement()) {
                // Ejecutar la consulta
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    // Iterar sobre los resultados
                    while (rs.next()) {
                        // Obtener datos de las columnas por nombre
                        int idPartido = rs.getInt("id_partido");
                        Date fecha = rs.getDate("fecha");
                        
                        // Mostrar los resultados
                        System.out.println("ID del partido: " + idPartido + ", Fecha: " + fecha);
                    }
                }
            }
        } catch (SQLException e) {
            // Manejar cualquier error de SQL
            e.printStackTrace();
        }
    }
}
