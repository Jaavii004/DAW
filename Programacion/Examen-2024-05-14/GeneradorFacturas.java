import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class GeneradorFacturas {
    public static double Total = 0;
    public static String Linea() {
        return "------------------------------------------------------------------";
    }

    public static String DatosPersonalesCliente(Statement st, int idCli) {
        try {
            String DatosCli = "SELECT NombreCliente, LineaDireccion1, Ciudad, CodigoPostal, Pais, Telefono\n" +
                                " FROM clientes\n" +
                                " WHERE CodigoCliente = "+idCli+";";
            ResultSet rs = st.executeQuery(DatosCli);
            if (rs.next()) {
                String result = rs.getString("NombreCliente")+" "+rs.getString("LineaDireccion1")+" "+rs.getString("Ciudad")+" "+rs.getInt("CodigoPostal")+" "+rs.getString("Pais")+" "+rs.getString("Telefono");
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
        return null;
    }
    
    public static String Productos(Statement st, int CodigoPedido) {
        try {
            double SubTotal = 0;
            String pro = "SELECT CodigoProducto, Nombre, Cantidad, PrecioUnidad \n" +
                                " FROM detallepedidos NATURAL JOIN exdaw.productos\n" +
                                "  WHERE CodigoPedido = "+CodigoPedido+"\n" +
                                " ORDER BY NumeroLinea;";
            ResultSet rs = st.executeQuery(pro);
            String result = "";
            while (rs.next()) {
                double Importe = 0;
                Importe = rs.getInt("Cantidad") * rs.getInt("PrecioUnidad");
                result += rs.getString("CodigoProducto")+" "+rs.getString("Nombre")+" "+rs.getInt("Cantidad")+" "+rs.getDouble("PrecioUnidad")+" "+Importe+" \n";
                SubTotal += rs.getInt("Cantidad") * rs.getInt("PrecioUnidad");
            }
            Total += SubTotal;
            result += "\nSubtotal: "+SubTotal+"\n";
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        // javac -cp :mysql-connector-j-8.3.0.jar *.java
        // java -cp :mysql-connector-j-8.3.0.jar Main
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fw = null;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/exdaw", "root", "dbrootpass");
            Statement st = con.createStatement();
            int idCliente = 0;
            System.out.print("Dime el IdCliente: ");
            try {
                idCliente = sc.nextInt();
                fw = new FileWriter("Factura_"+idCliente+".txt");
                String datpers = DatosPersonalesCliente(st, idCliente);
                fw.write(datpers+"\n");
                fw.write(Linea()+"\n");

                String SelPediCli = "SELECT CodigoPedido, FechaPedido, Estado, Comentarios \n" +
                                        "  FROM exdaw.pedidos \n" +
                                        "  WHERE CodigoCliente = "+idCliente+"\n" +
                                        "  ORDER BY FechaPedido;";
                ResultSet rs = st.executeQuery(SelPediCli);
                TreeMap<Integer, String> map = new TreeMap<Integer, String>();
                while (rs.next()) {
                    String sali = rs.getInt("CodigoPedido")+" "+rs.getString("FechaPedido")+" "+rs.getString("Estado")+" "+rs.getString("Comentarios");
                    sali = sali.replaceAll("null", "");
                    // Voy a guardar el Valor por el que ten
                    map.put(rs.getInt("CodigoPedido"), sali+"\n\n");
                }
                rs.close();
                // Voy a recorrer el Treemap porque no se pueden abrir 2 ResulSet
                Iterator<Integer> it = map.keySet().iterator();
                while(it.hasNext()){
                    Integer key = it.next();
                    fw.write(map.get(key));
                    fw.write(Productos(st, key));
                    fw.write(Linea()+"\n");
                }
                fw.write("Total: "+Total+"\n");
                double iva = Total*0.21;
                fw.write("IVA: "+iva+"\n");
                double pagar = Total+iva;
                fw.write("Importe a Pagar: "+pagar+"\n");
                fw.close();
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero.");
            }
            sc.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la bd: " + e.getErrorCode() + " - " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un numero.");
        } catch (IOException o) {
            System.out.println("Error con el fichero");
        }
    }
}