public class Estudiante extends Persona {
    private int IDestudiante;

    public Estudiante(){
        super(null, null, null);
    }
    public Estudiante(String nombre, String apellidos, String NIF, int Id) {
        super(nombre, apellidos, NIF);
        this.IDestudiante = Id;
    }
    public Estudiante(String nombre, String apellidos, String NIF, Direccion Direccion, int Id) {
        super(nombre, apellidos, NIF, Direccion);
        this.IDestudiante = Id;
    }

    public int getIDestudiante() {
        return IDestudiante;
    }
    public void setIDestudiante(int iDestudiante) {
        IDestudiante = iDestudiante;
    }

    public String toString() {
        return super.toString() + " IDestudiante:" + IDestudiante;
    }
}
