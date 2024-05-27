package com.acalabuig;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.acalabuig.model.Cultivo;
import com.acalabuig.model.Empleado;
import com.acalabuig.model.Maquinaria;
import com.acalabuig.model.Producto;

public class TestUnitarios {
    private Cultivo cultivo;
    private Empleado empleado;
    private Maquinaria maquinaria;
    private Producto producto;

    @Before
    public void setUp() {
        cultivo = new Cultivo("Trigo", 1, 100);
        empleado = new Empleado("Javier", "Programador", 2000);
        maquinaria = new Maquinaria("Tractor", 10, 13);
        producto = new Producto("Insecticida", 18);
    }

    @Test
    public void testCultivo() {
        assertEquals("Trigo", cultivo.getNombre());
        cultivo.setNombre("Arroz");
        assertNotEquals("Trigo", cultivo.getNombre());
        assertEquals(1, cultivo.getArea(), 0.1);
        cultivo.setArea(2);
        assertEquals(2, cultivo.getArea(), 0.1);
        assertEquals(100, cultivo.getRendimiento(), 0.1);
        cultivo.setRendimiento(14);
        assertEquals(14, cultivo.getRendimiento(), 0.1);
    }

    @Test
    public void testEmpleado() {
        assertEquals("Javier", empleado.getNombre());
        empleado.setNombre("Escartii");
        assertEquals("Escartii", empleado.getNombre());
        assertEquals("Programador", empleado.getCargo());
        empleado.setCargo("Dire");
        assertEquals("Dire", empleado.getCargo());
        assertEquals(2000, empleado.getSalario(), 0.1);
        empleado.setSalario(1200);
        assertEquals(1200, empleado.getSalario(), 0.1);
    }

    @Test
    public void testMaquinaria() {
        assertEquals("Tractor", maquinaria.getTipo());
        maquinaria.setTipo("tractor");
        assertEquals("tractor", maquinaria.getTipo());
        assertEquals(10, maquinaria.getHoraUso(), 0.1);
        maquinaria.setHoraUso(134);
        assertEquals(134, maquinaria.getHoraUso(), 0.1);
        assertEquals(13, maquinaria.getEficiencia(), 0.1);
    }
}
