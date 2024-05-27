package com.acalabuig;

import org.junit.Before;
import org.junit.Test;

import com.acalabuig.model.Cultivo;
import com.acalabuig.model.Empleado;
import com.acalabuig.model.Maquinaria;
import com.acalabuig.model.Producto;

import static org.junit.Assert.*;

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
        assertEquals("Trigo" ,cultivo.getNombre());
        assertEquals(1, cultivo.getArea(), 0.1);
        assertEquals(100, cultivo.getRendimiento(), 0.1);
    }

    @Test
    public void testEmpleado() {
        assertNotEquals("Nombre", empleado.getNombre());
        assertEquals("Javier", empleado.getNombre());
        assertEquals("Programador", empleado.getCargo());
        assertEquals(2000, empleado.getSalario(),0.1);
    }

    @Test
    public void testMaquinaria() {
        assertNotEquals("Tractor2", maquinaria.getTipo());
        assertEquals("Tractor",maquinaria.getTipo());
        assertEquals(10, maquinaria.getHoraUso(), 0.1);
        assertEquals(13, maquinaria.getEficiencia(),0.1);
    }

    @Test
    public void testProducto() {
        assertEquals("Insecticida", producto.getNombre());
        assertNotEquals("Abono", producto.getNombre());
        assertEquals(18, producto.getPrecio(), 0.1);
        assertNotEquals(19, producto.getPrecio(),0.1);
    }
}
