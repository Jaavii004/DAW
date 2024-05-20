package org.antonio;

/**
 * Clase que implementa la interfaz Personaje y representa a Luffy.
 * @version 1.0
 */
public class Luffy implements Personaje{
    private String nombre;
    private int poder;

    /**
     * Constructor de la clase Luffy.
     *
     * @param nombre Nombre del personaje.
     * @param poder Poder de ataque del personaje.
     */
    public Luffy(String nombre, int poder) {
        this.nombre = nombre;
        this.poder = poder;
    }

    /**
     * Método para obtener nombre.
     *
     * @return nombre del personaje
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener el poder.
     *
     * @return poder del personaje
     */
    public int getPoder() {
        return poder;
    }

    /**
     * Método para atacar a un enemigo.
     *
     * @param enemigo Personaje al que se le va a atacar.
<     * @see #recibirDanio(int)>
     */
    public void atacar(Personaje enemigo) {
        enemigo.recibirDanio(poder);
    }

    /**
     * Recibe daño.
     *
     * @param cantidadDanio la cantidad de daño recibido por el personaje
     */
    @Override
    public void recibirDanio(int cantidadDanio){
        this.poder -= cantidadDanio;
    }
}