package org.antonio;

import org.junit.Test;
import static org.junit.Assert.*;

import org.antonio.Calculator;

public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator cal = new Calculator();
        assertEquals(5, cal.add(5,0));
        assertEquals(6, cal.add(5,1));
        assertEquals(-5, cal.add(-5,0));
        assertEquals(-6, cal.add(-5,-1));
        assertNotEquals(-9, cal.add(-5,0));
        assertNotEquals(-7, cal.add(-5,-1));
    }

    @Test
    public void testSubtract(){
        Calculator cal = new Calculator();
        assertEquals(5, cal.subtract(5,0));
        assertEquals(4, cal.subtract(5,1));
        assertEquals(0, cal.subtract(-5,-5));
        assertEquals(-4, cal.subtract(-5,-1));
        assertNotEquals(-9, cal.subtract(-5,0));
        assertNotEquals(-7, cal.subtract(-5,-1));
    }

    @Test
    public void testMultiply(){
        Calculator cal = new Calculator();
        assertEquals(0, cal.multiply(5,0), 0.01);
        assertEquals(-5, cal.multiply(5,-1), 0.01);
        assertEquals(25, cal.multiply(-5,-5), 0.01);
        assertEquals(5, cal.multiply(-5,-1), 0.01);
        assertNotEquals(-9, cal.multiply(-5,0), 0.01);
        assertNotEquals(-7, cal.multiply(-5,-1), 0.01);
    }

    @Test
    public void testDivide(){
        Calculator cal = new Calculator();
        assertEquals(2, cal.divide(4,2),0.01);
        assertEquals(-5, cal.divide(5,-1),0.01);
        assertEquals(1, cal.divide(-5,-5),0.01);
        assertEquals(5, cal.divide(-5,-1),0.01);
        assertNotEquals(-9, cal.divide(-5,8),0.01);
        assertNotEquals(-7, cal.divide(-5,-1),0.01);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDivideByZero(){
        Calculator cal = new Calculator();
        cal.divide(5,0);
    }
}
