package org.antonio;

import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CancionTest {
    private Cancion cancion;

    @Before
    public void setUp() {
        cancion = new Cancion("Bohemian Rhapsody", "Queen", 355);
    }

    @Test
    public void testGetters() {
        assertEquals("Bohemian Rhapsody", cancion.getTitulo());
        assertEquals("Queen", cancion.getArtista());
        assertEquals(355, cancion.getDuracion());
    }

    @Test
    public void testSetters() {
        cancion.setTitulo("Cancion");
        assertEquals("Cancion", cancion.getTitulo());
        cancion.setArtista("Placido Domingo");
        assertEquals("Placido Domingo", cancion.getArtista());
        cancion.setDuracion(100);
        assertEquals(100, cancion.getDuracion());
    }
}
