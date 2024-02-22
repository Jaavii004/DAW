public class Devolucion extends Formulario{
    private String producto;
    private double precio;

    public Devolucion(String cliente, String producto, double precio) {
        super("DE", cliente);
        this.producto = producto;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return super.toString()+"\nProducto: " + producto + "\nPrecio: " + precio;
    }

}