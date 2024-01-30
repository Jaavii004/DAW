package lib;

public class Tiempo {
    private int horas;
    private int minutos;
    private int segundos;

    public String toString() {
        return horas+"h "+ minutos + "m " + segundos + "s";
    }

    // Constructores
    public Tiempo () {
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
    }

    public Tiempo (int horas, int minutos,int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public void suma (int horas, int minutos,int segundos) {
        this.horas += horas;
        this.minutos += minutos;
        this.segundos += segundos;
    }

    public void resta (int horas, int minutos,int segundos) {
        this.horas -= horas;
        this.minutos -= minutos;
        this.segundos -= segundos;
    }

    
}
