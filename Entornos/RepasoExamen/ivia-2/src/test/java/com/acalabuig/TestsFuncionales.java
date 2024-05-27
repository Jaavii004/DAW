package com.acalabuig;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.acalabuig.model.Cultivo;
import com.acalabuig.model.Empleado;
import com.acalabuig.model.Maquinaria;
import com.acalabuig.model.Producto;

public class TestsFuncionales {

    @Test(expected = IllegalArgumentException.class)
    public void testCultivoConstructorException() {
        new Cultivo("Rodolfo", -12, -13);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmpleadoConstructorException() {
        new Empleado("", "Director", 12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProductoConstructorException() {
        new Producto("", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaquinariaConstructorException() {
        new Maquinaria("", 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaquinariaHorasNegativasException() {
        new Maquinaria("Maquina", -1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaquinariaHectareasNegativasException() {
        new Maquinaria("Maquina", 1, -12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmpleadoAumentoNegativoException() {
        new Empleado("Javier", "Dire", -12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProductoDescuentoInvalidoPorAbajoException() {
        Producto pro = new Producto("Patata", 12);
        assertEquals(10.56, pro.calcularPrecioConDescuento(-12), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProductoDescuentoInvalidoPorArribaException() {
        Producto pro = new Producto("Patata", 12);
        assertEquals(10.56, pro.calcularPrecioConDescuento(120), 0.1);
    }
    
}
