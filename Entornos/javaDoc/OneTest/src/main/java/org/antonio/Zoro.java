package org.antonio;

/**
 *  Clase que implementa la interfaz Personaje y representa a Zoro.
 * @version 1.0
 */
public class Zoro implements Personaje{
    private String nombre;
    private int poder;

    /**
     * Construye un objeto Zoro con el nombre y poder dados.
     * 
     * @param nombre el nombre del personaje Zoro
     * @param poder el poder del personaje Zoro
     */
    public Zoro(String nombre, int poder) {
        this.nombre = nombre;
        this.poder = poder;
    }

    /**
     * Devuelve el nombre del personaje Zoro.
     * 
     * @return el nombre del personaje Zoro
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el poder del personaje Zoro.
     * 
     * @return el poder del personaje Zoro
     */
    public int getPoder() {
        return poder;
    }

    /**
     * Ataca a otro personaje.
     * 
     * @deprecated Este metodo esta deprecated. Usa este nuevo {@link #nueevoAtacar(Personaje)}.
     * @param enemigo el personaje que se va a atacar
     * @see #recibirDanio(int)
     */
    @Deprecated
    public void atacar(Personaje enemigo) {
        enemigo.recibirDanio(poder);
    }

    /**
     * Ataca a otro personaje.
     * 
     * @param enemigo el personaje que se va a atacar
     * @see #atacar(Personaje)
     */
    public void nueevoAtacar(Personaje enemigo) {
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
