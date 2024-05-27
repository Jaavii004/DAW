package com.acalabuig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import com.acalabuig.model.Empleado;

public class EmpleadoTest {
    private Empleado empleado;

    @Before
    public void setUp() {
        empleado = new Empleado("Manuel", "Director", 2500);
    }

    @Test
    public void testCalculaSalarioAnual() {
        assertEquals(30000, empleado.calculaSalarioAnual(), 0.1);
        assertNotEquals(20000, empleado.calculaSalarioAnual(), 0.1);
    }

    @Test
    public void testDarAumento() {
        empleado.darAumento(12);
        assertEquals(2800, empleado.getSalario(), 0.1);
        assertNotEquals(2100, empleado.getSalario(), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNombreEmpleadoNoVacio() {
        Empleado emp2 = new Empleado(null, "Dire", 1345);
        Empleado emp3 = new Empleado("", "Dire", 1235);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSalarioDebeSerPositivo() {
        Empleado emp2 = new Empleado("Juan", "Dire", 0);
        Empleado emp3 = new Empleado("Pedro", "Dire", -1245);
    }

}
