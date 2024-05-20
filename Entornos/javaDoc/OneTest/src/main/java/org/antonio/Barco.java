package org.antonio;

/**
 * La clase Barco representa un barco con un nombre y una capacidad.
 * @version 1.0
 */
public class Barco {
    private String nombre;
    private int capacidad;

    /**
     * Crea un nuevo objeto Barco con el nombre y la capacidad especificados.
     * 
     * @param nombre    el nombre del barco
     * @param capacidad la capacidad del barco
     */
    public Barco(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    /**
     * Obtiene el nombre del barco.
     * 
     * @return el nombre del barco
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la capacidad del barco.
     * 
     * @return la capacidad del barco
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Agrega un tripulante al barco si la capacidad no ha sido alcanzada.
     * 
     * @return true si se agregó el tripulante, false si la capacidad está completa
     */
    public boolean agregarTripulante() {
        if (capacidad < 10) {
            capacidad++;
            return true;
        }
        return false;
    }
}
