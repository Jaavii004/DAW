package org.antonio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de Usuario
 * 
 * @version 1.0
 */
class Usuario {
    private String nombre;
    private List<Playlist> playlists;

    /**
     * Constructor de la clase Usuario
     * 
     * @param nombre el nombre del Usuario
     */
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.playlists = new ArrayList<>();
    }

    /**
     * Devolver el nombre del Usuario
     * 
     * @return el nombre del Usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambiar el nombre del Usuario
     * 
     * @param nombre el nombre del Usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener la lista de las Playlist las Usuario
     * 
     * @return la lista de las Playlist
     * @since 0.9
     */
    public List<Playlist> getPlaylists() {
        return playlists;
    }

    /**
     * Agregar una nueva Playlist a el Usuario
     * 
     * @param playlist nueva Playlist para agregar
     */
    public void agregarPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    /**
     * Eliminar una Playlist de la lista del usuario
     * 
     * @param playlist eliminar una Playlist del Usuario
     * @since 0.9
     */
    public void eliminarPlaylist(Playlist playlist) {
        playlists.remove(playlist);
    }

    /**
     * Mostrar las Playlist del usuario
     * 
     * @return todas las Playlist
     */
    public String mostrarPlaylists() {
        System.out.println("Playlists de '" + nombre + "':");
        String salida_playlists = "Playlists de '" + nombre + "':";
        for (Playlist playlist : playlists) {
            System.out.println("- " + playlist.getNombre());
            salida_playlists += "- " + playlist.getNombre();
        }

        return salida_playlists;
    }

    /**
     * Buscar una cancion en la Playlist del Usuario
     * 
     * @param tituloCancion el titulo de la cancion a buscar en las Playlist
     * @return el resultado de la busqueda de la cancion
     */
    public String buscarCancionEnPlaylists(String tituloCancion) {
        System.out.println("Resultados de la búsqueda de '" + tituloCancion + "' en las playlists de '" + nombre + "':");
        String salida_cancion_playlist = "Resultados de la búsqueda de '" + tituloCancion + "' en las playlists de '" + nombre + "':";
        for (Playlist playlist : playlists) {
            System.out.println("- Playlist: " + playlist.getNombre());
            System.out.println(playlist.getCanciones().size());
            for (Cancion cancion : playlist.getCanciones()) {
                if (cancion.getTitulo().equalsIgnoreCase(tituloCancion)) {
                    System.out.println("- " + cancion.getTitulo() + " (" + cancion.getArtista() + ") - Playlist: " + playlist.getNombre());
                    salida_cancion_playlist += "- " + cancion.getTitulo() + " (" + cancion.getArtista() + ") - Playlist: " + playlist.getNombre();
                }
            }
        }

        return salida_cancion_playlist;
    }
}
