package com.acalabuig;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.acalabuig.model.Producto;

public class ProductoTest {
    private Producto producto;

    @Before
    public void setUp() {
        producto = new Producto("Insecticida", 12);
    }

    @Test
    public void testCalcularPrecioConDescuento() {
        assertEquals(10.56, producto.calcularPrecioConDescuento(12), 0.1);
        assertNotEquals(12, producto.calcularPrecioConDescuento(1), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNombreProductoNoVacio() {
        producto = new Producto(null, 12);
        producto = new Producto("", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrecioDebeSerPositivo() {
        producto = new Producto("Produ", 0);
        producto = new Producto("Producto", -2);
        producto = new Producto("Producto", -0);
    }
}
