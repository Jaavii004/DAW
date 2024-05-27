package org.antonio;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 */
class Playlist {
    private String nombre;
    private List<Cancion> canciones;

    /**
     * Constructor de la clase Playlist
     * 
     * @param nombre el nombre de la Playlist
     */
    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    /**
     * Obtener el nombre de la Playlist
     * 
     * @return el nombre de la Playlist
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambiar el nombre de la Playlist
     * 
     * @param nombre cambiar el nombre de la Playlist
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devolver la lista de canciones que tiene cada Playlist
     * 
     * @return lista de canciones de cada Playlist
     */
    public List<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Agregar una cancion a la Playlist
     * 
     * @param cancion agregar cancion a la Playlist
     */
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    /**
     * Eliminar cancion de la Playlist
     * 
     * @param cancion eliminar cancion de la Playlist
     */
    public void eliminarCancion(Cancion cancion) {
        canciones.remove(cancion);
    }

    /**
     * Devolver la duracion total de la Playlist
     * 
     * @return duracion total de la Playlist
     * @since 1.0
     */
    public int getDuracionTotal() {
        int duracionTotal = 0;
        for (Cancion cancion : canciones) {
            duracionTotal += cancion.getDuracion();
        }
        return duracionTotal;
    }

    /**
     * Devolver todas las canciones con sus artistas de la Playlist
     * 
     * @return devoilver todos los titulos y artistas de la Playlist
     * @since 0.9
     */
    public String mostrarCanciones() {
        System.out.println("Canciones en la playlist '" + nombre + "':");
        String salida_canciones = "Canciones en la playlist '" + nombre + "':";
        for (Cancion cancion : canciones) {
            System.out.println("- " + cancion.getTitulo() + " (" + cancion.getArtista() + ")");
            salida_canciones += "- " + cancion.getTitulo() + " (" + cancion.getArtista() + ")";
        }

        return salida_canciones;
    }
}
