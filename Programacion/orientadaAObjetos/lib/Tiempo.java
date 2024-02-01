package lib;

public class Tiempo {
    private int horas;
    private int minutos;
    private int segundos;

    public String toString() {
        return (horas+"h "+ minutos + "m " + segundos + "s");
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
        while (this.minutos >= 60 | this.segundos >= 60) {
            if (this.minutos >= 60) {
                this.minutos -= 60;
                this.horas += 1;
            }
            if (this.segundos >= 60) {
                this.segundos -= 60;
                this.minutos += 1;
            }
        }
    }

    public void suma (int horas, int minutos,int segundos) {
        this.horas += horas;
        this.minutos += minutos;
        this.segundos += segundos;
        while (this.minutos >= 60 | this.segundos >= 60) {
            if (this.minutos >= 60) {
                this.minutos -= 60;
                this.horas += 1;
            }
            if (this.segundos >= 60) {
                this.segundos -= 60;
                this.minutos += 1;
            }
        }
    }

    // con Tiempo
    public void suma (Tiempo nuevoTiempo) {
        this.horas += nuevoTiempo.getHoras();
        this.minutos += nuevoTiempo.getMinutos();
        this.segundos += nuevoTiempo.getSegundos();
        while (this.minutos >= 60 | this.segundos >= 60) {
            if (this.minutos >= 60) {
                this.minutos -= 60;
                this.horas += 1;
            }
            if (this.segundos >= 60) {
                this.segundos -= 60;
                this.minutos += 1;
            }
        }
    }

    public void resta (int horas, int minutos,int segundos) {
        if (this.horas < horas) {
           this.horas = 0; 
        }else{
            this.horas -= horas;
        }
        if (this.minutos < minutos) {
            if (this.horas > 0) {
                this.horas -= 1;
                this.minutos += 60;
                this.minutos -= minutos;
            }else{
                this.minutos = 0;
            }
        }else{
            this.minutos -= minutos;
        }

        if (this.segundos < segundos) {
            if (this.minutos > 0) {
                this.minutos -= 1;
                this.segundos += 60;
                this.segundos -= segundos;
            }else{
                if (this.horas > 0) {
                    this.horas -= 1;
                    this.minutos += 60;
                    this.segundos -= segundos;
                }else {
                    this.segundos = 0;
                }
            }
        }else{
            this.segundos -= segundos;
        }
        // si tengo 1m 30s y me restan 31 me tiene que quedar 0m y 59s
    }

    public void resta (Tiempo tiemporesta) {
        if (this.horas < tiemporesta.getHoras()) {
           this.horas = 0; 
        }else{
            this.horas -= tiemporesta.getHoras();
        }
        if (this.minutos < tiemporesta.getMinutos()) {
            if (this.horas > 0) {
                this.horas -= 1;
                this.minutos += 60;
                this.minutos -= tiemporesta.getMinutos();
            }else{
                this.minutos = 0;
            }
        }else{
            this.minutos -= tiemporesta.getMinutos();
        }

        if (this.segundos < tiemporesta.getSegundos()) {
            if (this.minutos > 0) {
                this.minutos -= 1;
                this.segundos += 60;
                this.segundos -= tiemporesta.getSegundos();
            }else{
                if (this.horas > 0) {
                    this.horas -= 1;
                    this.minutos += 60;
                    this.segundos -= tiemporesta.getSegundos();
                }else {
                    this.segundos = 0;
                }
            }
        }else{
            this.segundos -= tiemporesta.getSegundos();
        }
        // si tengo 1m 30s y me restan 31 me tiene que quedar 0m y 59s
    }

    // getters and setters
    public int getHoras() {
        return horas;
    }
    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

}
