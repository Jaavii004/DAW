public class Profesor extends Persona {
    private int nDespacho;

    // Constructores profesor
    public Profesor() {
        super(null, null, null);
    }
    public Profesor(String nombre, String apellidos, String NIF ,int nDespacho) {
        super(nombre, apellidos, NIF);
        this.nDespacho = nDespacho;
    }
    public Profesor(String nombre, String apellidos, String NIF ,Direccion direccion ,int nDespacho) {
        super(nombre, apellidos, NIF, direccion);
        this.nDespacho = nDespacho;
    }

    public String toString() {
        return super.toString() + "nDespacho:" + nDespacho ;
    }

    
}
