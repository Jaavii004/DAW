package com.acalabuig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import com.acalabuig.model.Maquinaria;

public class MaquinariaTest {
    private Maquinaria maquinaria;

    @Before
    public void setUp() {
        maquinaria = new Maquinaria("Tractor Amarillo", 10, 3);
    }

    @Test
    public void testCalcularTiempoArado() {
        assertEquals(4, maquinaria.calcularTiempoArado(12), 0.1);
        assertNotEquals(4.5, maquinaria.calcularTiempoArado(12), 0.1);
    }
    
    @Test
    public void testAnyadirHorasTrabajo() {
        maquinaria.anyadirHorasTrabajo(1234);
        assertEquals(1244, maquinaria.getHoraUso(), 0.1);
        assertNotEquals(1240, maquinaria.getHoraUso(), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTipoMaquinariaNoVacio() {
        maquinaria = new Maquinaria(null , 123, 1234);
        maquinaria = new Maquinaria("" , 123, 1234);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHorasUsoNoNegativo() {
        maquinaria = new Maquinaria("Tractor " , -123, 1234);
        maquinaria = new Maquinaria("" , -21, 1234);
    }

}
