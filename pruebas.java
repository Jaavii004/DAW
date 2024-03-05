import java.util.Scanner;

public class InterfazDeUsuario {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.agregarTablon(new Tablon("U1", 1000, 500, 10, 10000));
        inventario.agregarTablon(new Tablon("U2", 1000, 500, 20, 20000));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Introduce la referencia del tablón: ");
                String referencia = scanner.nextLine();
                System.out.print("Introduce el volumen en m3: ");
                double m3 = scanner.nextDouble();
                scanner.nextLine(); // Consume el salto de línea
                double[] resultados = ProgramaDeCalculos.calcular(inventario, referencia, m3);
                System.out.println("Precio total: " + resultados[0]);
                System.out.println("Unidades necesarias: " + resultados[1]);
                System.out.println("Precio por m3: " + resultados[2]);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}


public class ProgramaDeCalculos {
    public static double[] calcular(Inventario inventario, String referencia, double m3) throws Exception {
        Tablon tablon = inventario.obtenerTablon(referencia);
        if (tablon == null) {
            throw new Exception("Referencia no encontrada");
        }
        double volumen = tablon.getLargo() * tablon.getAncho() * tablon.getAlto();
        double unidadesNecesarias = m3 / volumen;
        double precioPorM3 = tablon.getPrecio() / volumen;
        double precioTotal = unidadesNecesarias * tablon.getPrecio();
        return new double[]{precioTotal, unidadesNecesarias, precioPorM3};
    }
}
