package org.antonio;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class UsuarioTest {
    private Usuario usuario;
    private Playlist playlist1;
    private Playlist playlist2;

    @Before
    public void setUp() {
        usuario = new Usuario("Juan");
        playlist1 = new Playlist("Mis Favoritas");
        playlist2 = new Playlist("Rock Clásico");
    }

    @Test
    public void testGetters() {
        assertEquals("Juan", usuario.getNombre());
    }

    @Test
    public void testSetters() {
        usuario.setNombre("Pedro");
        assertEquals("Pedro", usuario.getNombre());
    }

    @Test
    public void testCrearPlaylist() {
        usuario.agregarPlaylist(playlist1);
        usuario.agregarPlaylist(playlist2);
        assertEquals(2, usuario.getPlaylists().size());
        assertTrue(usuario.getPlaylists().get(0).getNombre().equals(playlist1.getNombre()));
    }

    @Test
    public void testEliminarPlaylist() {
        usuario.agregarPlaylist(playlist1);
        usuario.agregarPlaylist(playlist2);
        usuario.eliminarPlaylist(playlist1);
        assertEquals(1, usuario.getPlaylists().size());
        assertFalse(usuario.mostrarPlaylists().contains("Mis Favoritas"));
        assertTrue(usuario.mostrarPlaylists().contains("Rock Clásico"));
    }

    @Test
    public void testMostrarPlaylistDeUsuario() {
        usuario.agregarPlaylist(playlist1);
        usuario.agregarPlaylist(playlist2);
        assertEquals("Playlists de 'Juan':- Mis Favoritas- Rock Clásico", usuario.mostrarPlaylists());
        assertTrue(usuario.mostrarPlaylists().contains("Mis Favoritas"));
        assertFalse(usuario.mostrarPlaylists().contains("Las mejores"));
    }

    @Test
    public void testBuscarCancionEnPlaylist() {
        Cancion cancion1 = new Cancion("Bohemian Rhapsody", "Queen", 355);
        Cancion cancion2 = new Cancion("On", "Hecky", 33);
        playlist1.agregarCancion(cancion1);
        playlist2.agregarCancion(cancion2);

        usuario.agregarPlaylist(playlist1);
        usuario.agregarPlaylist(playlist2);
        assertEquals("Resultados de la búsqueda de 'Bohemian Rhapsody' en las playlists de 'Juan':- Bohemian Rhapsody (Queen) - Playlist: Mis Favoritas", usuario.buscarCancionEnPlaylists("Bohemian Rhapsody"));
        assertEquals("Resultados de la búsqueda de 'On' en las playlists de 'Juan':- On (Hecky) - Playlist: Rock Clásico", usuario.buscarCancionEnPlaylists("On"));
    }

}
