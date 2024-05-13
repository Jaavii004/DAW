package org.antonio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBatalla {

    Luffy luffy = new Luffy(null, 0);
    Zoro zoro = new Zoro(null, 0);



    @Before
    public void setUp() {
        luffy = new Luffy("Luffy", 100);
        zoro = new Zoro("Zoro", 80);
    }

    @Test
    public void testAtaqueLuffy() {
        luffy.atacar(zoro);
        assertEquals(-20, zoro.getPoder());
        assertNotEquals(0, zoro.getPoder());
    }

    @Test
    public void testAtaqueZoro() {
        zoro.atacar(luffy);
        assertEquals(20, luffy.getPoder());
        assertNotEquals(0, luffy.getPoder());
    }
    
}
