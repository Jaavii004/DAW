package com.jaavii004;

import org.junit.Test;

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

    @Test
    public void testAverage() {
        Ejercicios ej = new Ejercicios();
        assertEquals(5.0, ej.average(new int[] {5,5,5,5}), 0.01);
        assertEquals(2.5, ej.average(new int[] {1,2,3,4}), 0.01);
        assertNotEquals(2.52, ej.average(new int[] {1,2,3,4}), 0.01);
        assertEquals(-2.5, ej.average(new int[] {-1,-2,-3,-4}), 0.01);
    }

    @Test
    public void testBinarySearch() {
        Ejercicios ej = new Ejercicios();
        assertEquals(-1, ej.binarySearch(new int[] {1,2,3,4},5));
        assertEquals(4, ej.binarySearch(new int[] {1,2,3,4,5},5));
        assertTrue(-1 == ej.binarySearch(new int[] {1,2,3,4},5));
        assertTrue(0 == ej.binarySearch(new int[] {1,2,3,4},1));
        assertFalse(-1 == ej.binarySearch(new int[] {1,2,3,4},1));
    }

    @Test
    public void testCelsiusToFahrenheit() {
        Ejercicios ej = new Ejercicios();
        assertEquals(41, ej.celsiusToFahrenheit(5),0.01);
        assertFalse(42 == ej.celsiusToFahrenheit(8));
    }
}
