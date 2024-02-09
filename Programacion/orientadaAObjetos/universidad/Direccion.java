public class Direccion {
    private String calle;
    private String ciudad;
    private String codigoPostal;
    private String pais;

    // Constructor por si se te olvida ponerme algo
    public Direccion() {
        this.calle = "Paseo de la Castellana";
        this.ciudad = "Madrid";
        this.codigoPostal = "28024";
        this.pais = "Espanya";
    }
    public Direccion(String calle, String ciudad, String codigoPostal, String pais) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }
    @Override
    public String toString() {
        return "calle " + calle + ", ciudad " + ciudad + ", codigoPostal " + codigoPostal + ", pais " + pais ;
    }

}