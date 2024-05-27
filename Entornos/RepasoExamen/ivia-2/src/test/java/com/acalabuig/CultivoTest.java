package com.acalabuig;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.acalabuig.model.Cultivo;

public class CultivoTest {
    private Cultivo cultivo;

    @Before
    public void setUp() {
        cultivo = new Cultivo("Trigo", 1, 100);
    }

    @Test
    public void testCalcularRendimientoTotal() {
        assertEquals(100, cultivo.calcularRendimientoTotal(), 0.1);
        assertNotEquals(1000, cultivo.calcularRendimientoTotal(), 0.1);
    }

    @Test
    public void testCalcularIngresos() {
        assertEquals(1200, cultivo.calcularIngresos(12), 0.1);
        assertNotEquals(1300, cultivo.calcularIngresos(12), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNombreCultivoNoPuedeSerVacio() {
        new Cultivo(null, 12, 13);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAreaDebeSerPositivo() {
        new Cultivo("Arroz", -1, 3);
    }

}
