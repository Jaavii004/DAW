package lib;

public class Tiempo {
    private int horas;
    private int minutos;
    private int segundos;

    public String toString() {
        return (horas + "h " + minutos + "m " + segundos + "s");
    }

    // Constructores
    public Tiempo() {
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
    }

    public Tiempo(int horas, int minutos, int segundos) {
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

    public void suma(int horas, int minutos, int segundos) {
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
    public void suma(Tiempo nuevoTiempo) {
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

    public void resta(int horas, int minutos, int segundos) {
        if (this.horas < horas){
            this.horas = 0;
        }else{
            this.horas -= horas;
        }
        if (this.minutos < minutos){
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

        if (this.segundos < segundos){
            if (this.minutos > 0) {
                this.minutos -= 1;
                this.segundos += 60;
                this.segundos -= segundos;
            }else{
                if (this.horas > 0) {
                    this.horas -= 1;
                    this.minutos += 60;
                    this.segundos -= segundos;
                }else{
                    this.segundos = 0;
                }
            }
        }else{
            this.segundos -= segundos;
        }
        // si tengo 1m 30s y me restan 31 me tiene que quedar 0m y 59s
    }

    public void resta(Tiempo tiemporesta){
        if(this.horas < tiemporesta.getHoras()){
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
        } else {
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
                } else {
                    this.segundos = 0;
                }
            }
        } else {
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

    public static void ordenarTiempo(Tiempo[] tiempos) {
        ordenarTiempo(tiempos, 0, tiempos.length - 1);
    }

    private static void ordenarTiempo(Tiempo[] tiempos, int inicio, int fin) {
        Tiempo pivote;
        int indiceMenor;
        Tiempo tmp;
        int tmpganador;
        if (inicio <= fin) {
            pivote = tiempos[fin];
            indiceMenor = inicio - 1;
            for (int i = inicio+1; i <= fin; i++) {
                tmpganador = pivote.compareTo(tiempos[i]);
                if (tmpganador > 0) {
                    indiceMenor++;
                    tmp = tiempos[indiceMenor];
                    tiempos[indiceMenor] = tiempos[i];
                    tiempos[i] = tmp;
                }
            }
            // Para cambiar el ultimo pivote
            tmp = tiempos[indiceMenor + 1];
            tiempos[indiceMenor + 1] = tiempos[fin];
            tiempos[fin] = tmp;

            ordenarTiempo(tiempos, inicio, indiceMenor);
            // Para no coger ni el pivote ni los que ordena la otra parte
            ordenarTiempo(tiempos, indiceMenor + 2, fin);
        }
    }

    public int compareTo(Tiempo segundoTiempo) {
        int a = this.horas * 3600 + this.minutos * 60 + this.segundos;
        int b = segundoTiempo.horas * 3600 + segundoTiempo.minutos * 60 + segundoTiempo.segundos;
        int vuelta = 0;
        if (a<b) {
            vuelta = -1;
        }if (a>b) {
            vuelta = 1;
        }
        return vuelta;
    }
}