package pruebasFicheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import pruebasFicheros.Conexion;

public class Main {
    public static void main(String[] args) {
        Statement st = null;
        try {
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
                            Connection con = Conexion.getConnection("pruebas");
                            String query = "INSERT INTO users (name, apellido, grado, edad) VALUES ('"
                                            + name + "', '" + apellido + "', '" + grado + "', " + edad + ")";
                            st = con.createStatement();
                            st.executeUpdate(query);
                        } catch (Exception e) {
                            // TODO: handle exception
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