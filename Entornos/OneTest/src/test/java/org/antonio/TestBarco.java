package org.antonio;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestBarco {
    Barco barco = new Barco(null,0);
    Fruta fruta = new Fruta(null,false);
    Luffy luffy = new Luffy(null, 0);
    Zoro zoro = new Zoro(null, 0);

    @Before
    public void setUp() {
        barco = new Barco("Thousand Sunny",5);
        fruta = new Fruta("Manzana",false);
        luffy = new Luffy("Luffy", 20);
        zoro = new Zoro("Zoro", 20);
    }

    @Test
    public void testAgregarTripulante() {
        assertTrue(barco.agregarTripulante());
        assertTrue(barco.agregarTripulante());
        assertEquals(7, barco.getCapacidad());
    }

    @Test
    public void testAgregarTripulanteMaximo() {
        barco.setCapacidad(9);
        assertTrue(barco.agregarTripulante());
        assertFalse(barco.agregarTripulante());
        assertEquals(10, barco.getCapacidad());
    }
}
