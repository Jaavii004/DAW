import java.util.Scanner;

public class PruebaVehiculos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bicicleta bicicleta = new Bicicleta();
        Coche coche = new Coche();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        int opcion = 8;
        do {
            System.out.println();
            System.out.println("VEHÍCULOS");
            System.out.println("=========");
            System.out.println("1. Anda en bicicleta");
            System.out.println("2. Anda en coche");
            System.out.println("3. Ver kilometraje de la bicicleta");
            System.out.println("4. Ver kilometraje del coche");
            System.out.println("5. Ver kilometraje total");
            System.out.println("6. Ver vehículos totales");
            System.out.println("7. Salir");
            System.out.print("Elige una opción (1-7): ");
            opcion = sc.nextInt();

            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (opcion) {
                case 1:
                    bicicleta.andar(50);
                    System.out.println("Andar en bici");
                    break;
                case 2:
                    coche.andar(500);
                    System.out.println("Andar en coche");
                    break;
                case 3:
                    System.out.println("Kilometros de la bicicleta: " + bicicleta.getKmrecorre());
                    break;
                case 4:
                    System.out.println("Kilometros del coche: " + coche.getKmrecorre());
                    break;
                case 5:
                    System.out.println("Kilometros total: " + Vehiculos.getKilometrosTotales());
                    break;
                case 6:
                    System.out.println("Vehículos totales: " + Vehiculos.getVehiculosCreados());
                    break;
                case 7:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 7);
        sc.close();
    }
}