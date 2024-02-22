public abstract class Formulario {
    private String idClient;
    private String NomCliente;
    private static int TotalFormularios = 1;

    public Formulario(String queEs,String Nomclient) {
        this.idClient = queEs+TotalFormularios;
        this.NomCliente = Nomclient;
        TotalFormularios++;
    }

    public static int getTotalFormularios() {
        return TotalFormularios;
    }

    @Override
    public String toString() {
        return "ID: "+idClient+"\nCliente: "+NomCliente;
    }

    public String getidClient() {
        return idClient;
    }
    
}