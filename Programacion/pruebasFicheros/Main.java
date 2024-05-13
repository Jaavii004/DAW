import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) {
        Statement st = null;
        try {
            Connection con = Conexion.getConnection("pruebas");
            st = con.createStatement();
            BufferedReader br = new BufferedReader(new FileReader("users.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    if (!line.contains("grado,edad")) {
                        String[] str = line.split(",");
                        String name = str[1];
                        String apellido = str[2];
                        String grado = str[3];
                        int edad = Integer.parseInt(str[4]);
                        try {
                            String query = "INSERT INTO Usuarios (nombre, apellido, grado, edad) VALUES ('"
                                            + name + "', '" + apellido + "', '" + grado + "', " + edad + ")";
                            st.executeUpdate(query);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}