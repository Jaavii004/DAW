package lib;

public class Cafetera {
    private int capacidadMaxima;
    private int cantidadActual;

    // constructores
    public Cafetera() {
        this.capacidadMaxima = 1000;
        this.cantidadActual = 0;
    }

    public Cafetera(int a_nivmax) {
        this.capacidadMaxima = a_nivmax;
        this.cantidadActual = a_nivmax;
    }
    public Cafetera(int a_nivmax,int nivact) {
        this.capacidadMaxima = a_nivmax;
        if (a_nivmax < nivact) {
            this.cantidadActual = nivact;
        }else{
            this.cantidadActual = a_nivmax;
        }
    }

    // Getters y Setters
    public int getCapacidadMaxima() {
        return this.capacidadMaxima;
    }
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCantidadActual() {
        return this.cantidadActual;
    }
    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }



    public void llenarcafetera() {
        this.cantidadActual = this.capacidadMaxima;
    }

    public void servirTaza(int nivtaza) {
        if (nivtaza > this.cantidadActual) {
            this.cantidadActual = 0;
        }else{
            this.cantidadActual -= nivtaza;
        }
    }
    public void vaciarCafetera (){
        this.cantidadActual = 0;
    }
    public void agregarCafe (int agcafe) {
        int cantActualtmp = this.cantidadActual + agcafe;
        if (this.cantidadActual > cantActualtmp) {
            this.cantidadActual = cantActualtmp;
        }else{
            this.cantidadActual = this.capacidadMaxima;
        }
    }
}
