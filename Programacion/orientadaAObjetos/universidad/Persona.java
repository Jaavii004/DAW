public class Persona {
    private String nombre;
    private String apellidos;
    private String NIF;
    private Direccion direccion;

    public Persona(String nombre, String apellidos, String NIF, Direccion direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.direccion = direccion;
    }

    public Persona(String nombre,String apellidos,String NIF) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.direccion = new Direccion(null,null,null,null);
    }

    @Override
    public String toString() {
        return "nombre " + nombre + ", apellidos " + apellidos + ", NIF " + NIF + ", direccion " + direccion.toString();
    }

}