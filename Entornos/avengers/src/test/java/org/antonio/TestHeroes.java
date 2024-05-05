package org.antonio;

import org.junit.Test;

import static org.junit.Assert.*;

import org.antonio.Model.GestorHeroes;
import org.antonio.Model.Heroe;
import org.junit.Before;

public class TestHeroes {

    Heroe ironman = new Heroe(null, null, null, null);
    Heroe spiderman = new Heroe(null, null, null, null);
    Heroe capitanAmerica = new Heroe(null, null, null, null);

    GestorHeroes gh = null;

    @Before
    public void setUp(){
        ironman = new Heroe("Iron Man", "Traje de alta tecnología", "Millonario y filántropo", "descripcion");
        spiderman = new Heroe("Spider-Man", "Sentido arácnido, trepador", "Tímido estudiante de secundaria", "descripcion");
        capitanAmerica = new Heroe("Capitán América", "Superfuerza, agilidad, resistencia", "Soldado de la Segunda Guerra Mundial", "descripcion");

        gh = new GestorHeroes();
        gh.agregarHeroe(ironman);
        gh.agregarHeroe(spiderman);
        gh.agregarHeroe(capitanAmerica);
    }

    @Test
    public void testGettersHeroe(){
        assertNotEquals(null, ironman.getNombre());
        assertEquals("Iron Man", ironman.getNombre());
        assertEquals("Spider-Man", spiderman.getNombre());
        assertEquals("Capitán América", capitanAmerica.getNombre());

        assertEquals("Traje de alta tecnología", ironman.getSuperpoderes());
        assertEquals("Sentido arácnido, trepador", spiderman.getSuperpoderes());
        assertEquals("Superfuerza, agilidad, resistencia", capitanAmerica.getSuperpoderes());

        assertEquals("Millonario y filántropo", ironman.getBiografia());
        assertEquals("Tímido estudiante de secundaria", spiderman.getBiografia());
        assertEquals("Soldado de la Segunda Guerra Mundial", capitanAmerica.getBiografia());
    }

    @Test
    public void testSettersHeroe(){
        Heroe catWoman = new Heroe(null, null, null, null);
        catWoman.setNombre("Cat Woman");
        catWoman.setSuperpoderes("Trepar y arañar");
        catWoman.setBiografia("Es la amiga de Batman");

        assertEquals("Cat Woman", catWoman.getNombre());
        assertEquals("Trepar y arañar", catWoman.getSuperpoderes());
        assertEquals("Es la amiga de Batman", catWoman.getBiografia());

        assertNotEquals(null, catWoman.getNombre());
    }
}


