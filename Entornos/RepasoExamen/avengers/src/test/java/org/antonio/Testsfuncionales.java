package org.antonio;

import static org.junit.Assert.*;

import org.antonio.Exception.HeroeNoEncontradoException;
import org.antonio.Model.GestorHeroes;
import org.antonio.Model.Heroe;
import org.junit.Test;


public class Testsfuncionales {
    @Test(expected = HeroeNoEncontradoException.class)
    public void testComprobarExcepcion() throws HeroeNoEncontradoException {
        GestorHeroes gh = new GestorHeroes();
        Heroe heroe1 = new Heroe("Iron Man", "Traje de alta tecnología", "Millonario y filántropo", "descripcion");
        Heroe heroe2 = new Heroe("Capitán América", "Superfuerza, agilidad, resistencia", "Soldado de la Segunda Guerra Mundial", "descripcion");
        gh.agregarHeroe(heroe1);
        gh.agregarHeroe(heroe2);

        assertEquals(heroe1, gh.buscarHeroe("Iron Man"));
        assertEquals(heroe2, gh.buscarHeroe("Capitán América"));
        assertEquals(null, gh.buscarHeroe("Javier"));
        assertNotEquals(heroe1, gh.buscarHeroe("Capitán América"));
        assertNotEquals(heroe2, gh.buscarHeroe(""));


        gh.buscarHeroe("Javier");
        gh.buscarHeroe("");
        gh.buscarHeroe("Capitán América");
    } 
}


