package org.antonio;

import static org.junit.Assert.*;

import org.antonio.Model.Heroe;
import org.junit.Test;

public class TestHeroesIntegracion {

    @Test
    public void testSettersHeroe(){
        Heroe catWoman = new Heroe(null, null, null);
        catWoman.setNombre("Cat Woman");
        catWoman.setSuperpoderes("Trepar y arañar");
        catWoman.setBiografia("Es la amiga de Batman");

        assertEquals("Cat Woman", catWoman.getNombre());
        assertEquals("Trepar y arañar", catWoman.getSuperpoderes());
        assertEquals("Es la amiga de Batman", catWoman.getBiografia());

        assertNotEquals("Capitan América", catWoman.getNombre());
    }
}
