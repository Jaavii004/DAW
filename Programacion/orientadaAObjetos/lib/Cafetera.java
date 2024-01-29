package lib;

public class Cafetera {
    private int capacidadMaxima;
    private int cantidadActual;

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
}
