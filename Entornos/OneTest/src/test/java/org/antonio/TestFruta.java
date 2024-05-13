package org.antonio;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class TestFruta {
    Fruta fruta = new Fruta(null,false);
    Fruta fru = new Fruta(null,true);

    @Before
    public void setUp() {
        fruta = new Fruta("Manzana",true);
        fru = new Fruta("Fruta del diablo",false);

    }

    @Test
    public void testPuedoComerFrutaDeliciosa() {
        assertTrue(fruta.puedoComer());
    }

    @Test
    public void testPuedoComerFrutaDelDiablo() {
        assertFalse(fru.puedoComer());
    }

    @Test
    public void testPuedoComerFrutaNoDeliciosa() {
        assertFalse(fruta.puedoComer());
    }

}
