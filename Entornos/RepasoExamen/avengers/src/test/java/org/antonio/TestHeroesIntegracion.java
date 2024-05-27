package org.antonio;

import static org.junit.Assert.*;

import org.antonio.Exception.HeroeNoEncontradoException;
import org.antonio.Model.GestorHeroes;
import org.antonio.Model.Heroe;
import org.junit.Test;

public class TestHeroesIntegracion {

    @Test
    public void testGestorHeroes() throws HeroeNoEncontradoException {
        GestorHeroes gh = new GestorHeroes();
        Heroe heroe1 = new Heroe("Iron Man", "Traje de alta tecnología", "Millonario y filántropo", "descripcion");
        Heroe heroe2 = new Heroe("Capitán América", "Superfuerza, agilidad, resistencia", "Soldado de la Segunda Guerra Mundial", "descripcion");

        gh.agregarHeroe(heroe1);
        gh.agregarHeroe(heroe2);

        assertTrue(false == gh.getHeroes().isEmpty());
        assertEquals(2, gh.getHeroes().size());
        assertEquals(heroe1, gh.buscarHeroe("Iron Man"));
        assertEquals(heroe2, gh.buscarHeroe("Captain America"));
        assertNotEquals(heroe1, gh.buscarHeroe("Capitán América"));
        assertNotEquals(heroe2, gh.buscarHeroe(""));
    }
}
