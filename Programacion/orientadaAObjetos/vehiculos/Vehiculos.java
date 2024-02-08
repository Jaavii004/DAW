public class Vehiculos {
    private static int vehiculosCreados = 0;
    private static int kilometrosTotales = 0;
    private int kmrecorre = 0;

    public Vehiculos(){
        Vehiculos.vehiculosCreados++;
    }
    public Vehiculos(int kmAct) {
        Vehiculos.vehiculosCreados++;
        Vehiculos.kilometrosTotales+=kmAct;
    }

    public void andar(int kmand) {
        this.kmrecorre += kmand;
        Vehiculos.kilometrosTotales += kmand;
    }
    
    public int getKmrecorre() {
        return kmrecorre;
    }
    public static int getVehiculosCreados() {
        return vehiculosCreados;
    }

    public static int getKilometrosTotales() {
        return kilometrosTotales;
    }
}