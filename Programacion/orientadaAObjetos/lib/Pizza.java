package lib;
import java.util.Random;

public class Pizza {
    private String tamaño;
    private String tipo;
    private String estado;
    public static int TotalPedidas = 0;
    public static int TotalServidas = 0;
    private String[] SABORES = {"margarita", "cuatro quesos", "funghi"};
    private String[] TAMAÑO = {"mediana", "familiar"};

    // Te saco un sabor y tamaño aleatorio por no especificarlo
    // Constructor aleatorio
    public Pizza () {
        Random random = new Random();
        this.tamaño = TAMAÑO[random.nextInt(2)];
        this.tipo = SABORES[random.nextInt(3)];
        this.estado = "pedida";
        TotalPedidas += 1;
    }
    public Pizza (String tipo, String tama) {
        this.tamaño = tama;
        this.tipo = tipo;
        this.estado = "pedida";
        TotalPedidas += 1;
    }


    public void sirve() {
        if (this.estado.equals("servida")) {
            System.out.println("esa pizza ya se ha servido");
        }else{
            this.estado = "servida";
            TotalServidas += 1;
        }
    }

    @Override
    public String toString() {
        return ("pizza " + tipo  + " " + tamaño + ", " + estado);
    }

    public String getTamaño() {
        return tamaño;
    }
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setTotalPedidas(int totalPedidas) {
        TotalPedidas = totalPedidas;
    }
    public void setTotalServidas(int totalServidas) {
        TotalServidas = totalServidas;
    }

    public static int getTotalPedidas() {
        return TotalPedidas;
    }

    public static int getTotalServidas() {
        return TotalServidas;
    }

}
