package org.antonio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de Cancion
 * 
 * @version 1.0
 */
class Cancion {
    private String titulo;
    private String artista;
    private int duracion;

    /**
     * Constructor de la clase Cancion
     * 
     * @param titulo es el titulo de la cancion
     * @param artista es el artista de la cancion
     * @param duracion es la duracion de la cancion
     */
    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    /**
     * Obtener el Titulo de la cancion
     * 
     * @return el titulo de la cancion
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Cambiar el titulo la cancion
     * 
     * @param titulo el titulo de la cancion
     * @since 1.0
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtener el artista de la cancion
     * 
     * @return el artista de la cancion
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Cambiar el artista de la cancion
     * 
     * @param artista el artista de la cancion
     */
    public void setArtista(String artista) {
        this.artista = artista;
    }

    /**
     * Obtener la duracion de la cancion
     * 
     * @return la duracion de la cancion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Cambiar la duracion de la cancion
     * 
     * @param duracion la duracion de la cancion
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
