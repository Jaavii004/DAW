package com.acalabuig;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.acalabuig.model.Empleado;

public class EmpleadoTest {
    private Empleado empleado;

    @Before
    public void setUp() {
        empleado = new Empleado("Javier", "Programador", 1200);
    }

    @Test
    public void testCalculaSalarioAnual() {
        assertEquals(14400, empleado.calculaSalarioAnual(), 0.1);
    }

    @Test
    public void testDarAumento() {
        empleado.darAumento(3);
        assertNotEquals(1200, empleado.getSalario(), 0.1);
        assertEquals(1236, empleado.getSalario(), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNombreEmpleadoNoVacio() {
        new Empleado(null, "Dire", 12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSalarioDebeSerPositivo() {
        new Empleado("Carlos", "Dire", -1230);
    }

}
