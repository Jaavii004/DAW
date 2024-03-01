public class Pedido extends Formulario{
    private String producto;
    private double precio;

    public Pedido(String cliente, String producto, double precio) {
        super("PE", cliente);
        this.producto = producto;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return super.toString()+"\nProducto: " + producto + "\nPrecio: " + precio;
    }
}
