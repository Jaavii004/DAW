package org.antonio;

import static org.junit.Assert.*;

import org.antonio.Exception.HeroeNoEncontradoException;
import org.antonio.Model.GestorHeroes;
import org.antonio.Model.Heroe;
import org.junit.Test;

public class TestBuscarHeroe {
    @Test (expected = HeroeNoEncontradoException.class)
    public void testBuscarHeroe() throws HeroeNoEncontradoException{
        GestorHeroes gh = new GestorHeroes();
        Heroe ironman = new Heroe("Iron Man", "Traje de alta tecnología", "Millonario y filántropo", "descripcion");
        Heroe spiderman = new Heroe("Spider-Man", "Sentido arácnido, trepador", "Tímido estudiante de secundaria", "descripcion");
        Heroe capitanAmerica = new Heroe("Capitán América", "Superfuerza, agilidad, resistencia", "Soldado de la Segunda Guerra Mundial", "descripcion");

        gh.agregarHeroe(capitanAmerica);
        gh.agregarHeroe(spiderman);
        gh.agregarHeroe(ironman);

        assertEquals("Traje de alta tecnología", gh.buscarHeroe("Iron Man").getSuperpoderes());
        assertEquals("Sentido arácnido", gh.buscarHeroePorSuperpoder("Sentido").getSuperpoderes());
        assertEquals("trepador", gh.buscarHeroePorSuperpoder("trepador").getSuperpoderes());
        assertNotEquals("trepador", gh.buscarHeroePorSuperpoder("trepador").getSuperpoderes());
    }
}
