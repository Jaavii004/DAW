package com.acalabuig;

import org.junit.Before;
import org.junit.Test;

import com.acalabuig.model.Cultivo;
import com.acalabuig.model.Empleado;
import com.acalabuig.model.Maquinaria;
import com.acalabuig.model.Producto;

public class TestFuncionales {
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

    @Test(expected = IllegalArgumentException.class)
    public void testCultivoConstructorException() {
        cultivo = new Cultivo(null, 1, 1);
        cultivo = new Cultivo("Arroz", -1, 1);
        cultivo = new Cultivo("Arroz", 1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmpleadoConstructorException() {
        empleado = new Empleado("", "", -12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProductoConstructorException() {
        producto = new Producto(null, -12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaquinariaConstructorException() {
        maquinaria = new Maquinaria(null, -12, -12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaquinariaHorasNegativasException() {
        maquinaria = new Maquinaria("Maquina", -12, 12);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMaquinariaHectareasNegativasException() {
        maquinaria = new Maquinaria("Tractor", 12, 14);
        maquinaria.calcularTiempoArado(-100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmpleadoAumentoNegativoException() {
        empleado = new Empleado("Javier", "Director", 600);
        empleado.darAumento(-51);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProductoDescuentoInvalidoPorAbajoException() {
        producto = new Producto("Insecticida", 19);
        producto.calcularPrecioConDescuento(-12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProductoDescuentoInvalidoPorArribaException() {
        producto = new Producto("Insecticida", 19);
        producto.calcularPrecioConDescuento(-2);
    }
}
