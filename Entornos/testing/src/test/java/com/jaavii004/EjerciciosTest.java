package com.jaavii004;

import org.junit.Test;

import java.sql.Array;

import static org.junit.Assert.*;

public class EjerciciosTest {
    @Test
    public void testSuma() {
        Ejercicios ej = new Ejercicios();
        assertEquals(5, ej.suma(3,2));
        assertEquals(3, ej.suma(0,3));
        assertEquals(-5, ej.suma(-3, -2));
        assertEquals(3, ej.suma(6, -3));
        assertEquals(3, ej.suma(3, 0));
        assertNotEquals(7, ej.suma(4, 2));
    }

    @Test
    public void testSort() {
        Ejercicios ej = new Ejercicios();
        assertArrayEquals(new int[] {1,2,3,4}, ej.sort(new int[] {4,2,3,1}));
        assertArrayEquals(new int[] {-4,-3,-2,-1}, ej.sort(new int[] {-4,-2,-3,-1}));
    }
}
