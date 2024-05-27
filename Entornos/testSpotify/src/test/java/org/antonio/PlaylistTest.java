package org.antonio;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class PlaylistTest {
    private Cancion cancion1;
    private Cancion cancion2;
    private Cancion cancion3;
    private Playlist playlist;

    @Before
    public void setUp() {
        cancion1 = new Cancion("Bohemian Rhapsody", "Queen", 355);
        cancion2 = new Cancion("Imagine", "John Lennon", 180);
        cancion3 = new Cancion("Hotel California", "Eagles", 390);
        playlist = new Playlist("Mis Favoritas");
    }

    @Test
    public void testGetters() {
        assertEquals("Mis Favoritas", playlist.getNombre());
    }

    @Test
    public void testSetters() {
        playlist.setNombre("Mis Favoritas 2");
        assertEquals("Mis Favoritas 2", playlist.getNombre());
    }

    @Test
    public void testAgregarCancion() {
        playlist.agregarCancion(cancion1);
        playlist.agregarCancion(cancion2);
        playlist.agregarCancion(cancion3);
        assertTrue(playlist.getCanciones().contains(cancion1));
        assertTrue(playlist.getCanciones().contains(cancion2));
        assertTrue(playlist.getCanciones().contains(cancion3));
        assertEquals(3, playlist.getCanciones().size());
    }

    @Test
    public void testEliminarCancion() {
        playlist.agregarCancion(cancion1);
        playlist.agregarCancion(cancion2);
        playlist.agregarCancion(cancion3);
        playlist.eliminarCancion(cancion1);
        assertEquals(cancion2, playlist.getCanciones().get(0));
        assertFalse(playlist.getCanciones().contains(cancion1));
        assertEquals(2, playlist.getCanciones().size());
    }

    @Test
    public void testDuracionTotal() {
        playlist.agregarCancion(cancion1);
        playlist.agregarCancion(cancion2);
        playlist.agregarCancion(cancion3);
        assertEquals(925, playlist.getDuracionTotal());
    }

    @Test
    public void testMostrarCanciones() {
        playlist.agregarCancion(cancion1);
        playlist.agregarCancion(cancion2);
        playlist.agregarCancion(cancion3);
        assertTrue(playlist.mostrarCanciones().contains("Bohemian Rhapsody"));
    }
}
