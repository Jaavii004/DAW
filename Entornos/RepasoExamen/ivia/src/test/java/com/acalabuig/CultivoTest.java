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
        assertNotEquals(12, cultivo.calcularRendimientoTotal(), 0.1);
    }

    @Test
    public void testCalcularIngresos() {
        assertEquals(400, cultivo.calcularIngresos(4), 0.1);
        assertNotEquals(100, cultivo.calcularIngresos(4), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNombreCultivoNoPuedeSerVacio() {
        Cultivo cultivo2 = new Cultivo(null, 12, 431);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAreaDebeSerPositivo() {
        Cultivo cultivo3 = new Cultivo("Cultivo", 0, 0);
        Cultivo cultivo4 = new Cultivo("Cultivo", -61273, 0);

    }

}
