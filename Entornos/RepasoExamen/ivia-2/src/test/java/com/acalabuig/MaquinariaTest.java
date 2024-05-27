package com.acalabuig;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.acalabuig.model.Maquinaria;

public class MaquinariaTest {
    private Maquinaria maquinaria;

    @Before
    public void setUp() {
        maquinaria = new Maquinaria("Tractor", 10, 12);
    }

    @Test
    public void testCalcularTiempoArado() {
        assertEquals(1, maquinaria.calcularTiempoArado(12), 0.1);
    }

    @Test
    public void testAnyadirHorasTrabajo() {
        maquinaria.anyadirHorasTrabajo(1);
        assertEquals(11, maquinaria.getHoraUso(), 0.1);
    }
}
