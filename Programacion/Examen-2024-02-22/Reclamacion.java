public class Reclamacion extends Formulario{
    private String texto;
    private String estado;

    public Reclamacion(String cliente, String texto) {
        super("RE", cliente);
        this.texto = texto;
        this.estado = "Abierta";
    }

    public void CerrarReclamacion() {
        this.estado = "Cerrada";
    }


    @Override
    public String toString() {
        return super.toString()+"\nTexto: "+this.texto+"\nEstado: "+this.estado;
    }
}

