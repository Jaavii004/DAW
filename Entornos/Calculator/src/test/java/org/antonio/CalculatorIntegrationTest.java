package org.antonio;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorIntegrationTest {
    @Test
    public void testAddAndSubstract() {
        Calculator cal = new Calculator();
        assertEquals(5, cal.add(5,cal.subtract(5, 5)));
        assertEquals(15, cal.add(5,cal.subtract(5, -5)));
        assertEquals(10, cal.add(5,cal.subtract(0, -5)));
        assertNotEquals(-5, cal.add(5,cal.subtract(-5, -5)));
        assertNotEquals(5, cal.add(5,cal.subtract(-5, 0)));
        assertTrue(5 == cal.add(5,cal.subtract(-5, -5)));
    }

    @Test
    public void testAddWithZero() {
        Calculator cal = new Calculator();
        assertEquals(5, cal.add(5,0));
        assertEquals(6, cal.add(6,0));
        assertNotEquals(5, cal.add(6,0));
        assertNotEquals(6, cal.add(5,0));
    }

    @Test
    public void testSubstractWithZero() {
        Calculator cal = new Calculator();
        assertEquals(5, cal.subtract(5,0));
        assertEquals(6, cal.subtract(6,0));
        assertNotEquals(5, cal.subtract(6,0));
        assertNotEquals(6, cal.subtract(5,0));
    }

    @Test
    public void testMultilyAndDivide() {
        Calculator cal = new Calculator();
        assertEquals(6.25, cal.multiply(5, cal.divide(5,4)),0.01);
    }

    @Test
    public void testMultiplyWithZero() {
        Calculator cal = new Calculator();
    }

    @Test
    public void testDivideWithZero() {
        Calculator cal = new Calculator();
    }
}
