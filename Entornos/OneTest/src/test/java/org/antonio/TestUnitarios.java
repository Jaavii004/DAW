package org.antonio;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TestUnitarios {

    Barco barco = new Barco(null,0);
    Barco barco1 = new Barco(null,0);
    Fruta fruta = new Fruta(null,false);
    Luffy luffy = new Luffy(null, 0);
    Zoro zoro = new Zoro(null, 0);



    @Before
    public void setUp() {
        barco = new Barco("Barco",20);
        barco1 = new Barco("Barcelona Robando al chelsea",20);
        fruta = new Fruta("Manzana",false);
        luffy = new Luffy("Luffy", 20);
        zoro = new Zoro("Zoro", 20);

    }

    @Test
    public void testGetterNombreBarco() {
        assertEquals("Barco", barco.getNombre());
        assertNotEquals("barcelona roba con aytekin", barco1.getNombre());
        assertNotEquals("Barco1", barco1.getNombre());
    }

    @Test
    public void testGetterCapacidadBarco() {
        assertEquals(20, barco1.getCapacidad());
        assertNotEquals(21, barco1.getCapacidad());
        assertNotEquals(19, barco1.getCapacidad());
        assertNotEquals(0, barco.getCapacidad());
    }

    @Test
    public void testSetNombreBarco() {
        Barco barco1 = new Barco("Barcelona Robando al chelsea",20);
        barco1.setNombre("Barcelona Robando al chelsea");
        assertEquals("Barcelona Robando al chelsea", barco1.getNombre());
        assertNotEquals("barcelona roba con aytekin", barco1.getNombre());
    }

    @Test
    public void testSetCapacidadBarco() {
        barco1.setCapacidad(20);
        assertEquals(20, barco1.getCapacidad());
        assertNotEquals(21, barco1.getCapacidad());
        assertNotEquals(19, barco1.getCapacidad());
        assertNotEquals(0, barco.getCapacidad());
    }

    // Test de Fruta
    @Test
    public void testGetterNombreFruta() {
        assertEquals("Manzana", fruta.getNombre());
        assertNotEquals("manzana", fruta.getNombre());
    }

    @Test
    public void testGetterEsDeliciosa() {
        assertEquals(false, fruta.esDeliciosa());
        assertNotEquals(true, fruta.esDeliciosa());
    }

    @Test
    public void testSetNombreFruta() {
        fruta.setNombre("Fruta Del diablo");
        assertNotEquals("Manzana", fruta.getNombre());
    }

    @Test
    public void testSetEsDeliciosa() {
        fruta.setEsDeliciosa(true);
        assertEquals(true, fruta.esDeliciosa());
        assertNotEquals(false, fruta.esDeliciosa());
    }

    // Test de luffy
    @Test
    public void testGetterNombreLuffy() {
        assertEquals("Luffy", luffy.getNombre());
        assertNotEquals("luffy", luffy.getNombre());
    }

    @Test
    public void testGetterPoderLuffy() {
        assertEquals(20, luffy.getPoder());
        assertNotEquals(21, luffy.getPoder());
        assertNotEquals(19, luffy.getPoder());
        assertNotEquals(0, luffy.getPoder());
    }

    @Test
    public void testSetNombreLuffy() {
        luffy.setNombre("Luffy Madridista");
        assertEquals("Luffy Madridista", luffy.getNombre());
        assertNotEquals("Luffy", luffy.getNombre());
    }

    @Test
    public void testSetPoderLuffy() {
        luffy.setPoder(20);
        assertEquals(20, luffy.getPoder());
        assertNotEquals(21, luffy.getPoder());
        assertNotEquals(19, luffy.getPoder());
        assertNotEquals(0, luffy.getPoder());
    }

    // Test de Zoro
    @Test
    public void testGetterNombreZoro() {
        assertEquals("Zoro", zoro.getNombre());
        assertNotEquals("zoro", zoro.getNombre());
    }

    @Test
    public void testGetterPoderZoro() {
        assertEquals(20, zoro.getPoder());
        assertNotEquals(21, zoro.getPoder());
        assertNotEquals(19, zoro.getPoder());
        assertNotEquals(0, zoro.getPoder());
    }

    @Test
    public void testSetNombreZoro() {
        zoro.setNombre("Zoro Madridista");
        assertEquals("Zoro Madridista", zoro.getNombre());
        assertNotEquals("Zoro", zoro.getNombre());
    }

    @Test
    public void testSetPoderZoro() {
        zoro.setPoder(20);
        assertEquals(20, zoro.getPoder());
        assertNotEquals(21, zoro.getPoder());
        assertNotEquals(19, zoro.getPoder());
        assertNotEquals(0, zoro.getPoder());
    }
}

