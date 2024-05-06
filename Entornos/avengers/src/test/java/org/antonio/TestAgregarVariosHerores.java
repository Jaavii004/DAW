package org.antonio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.antonio.Exception.HeroeNoEncontradoException;
import org.antonio.Model.GestorHeroes;
import org.antonio.Model.Heroe;
import org.junit.Test;

public class TestAgregarVariosHerores {
    @Test
    public void testAgregarVariosHerores() throws HeroeNoEncontradoException {
        GestorHeroes gh = new GestorHeroes();
        Heroe ironman = new Heroe("Iron Man", "rapido Traje de alta tecnología", "Millonario y filántropo", "descripcion");
        Heroe spiderman = new Heroe("Spider-Man", "rapido Sentido arácnido, trepador", "Tímido estudiante de secundaria", "descripcion");
        Heroe capitanAmerica = new Heroe("Capitán América", "rapido Superfuerza, agilidad, resistencia", "Soldado de la Segunda Guerra Mundial", "descripcion");

        gh.agregarHeroe(capitanAmerica);
        gh.agregarHeroe(spiderman);
        gh.agregarHeroe(ironman);
        
        assertEquals(capitanAmerica.getNombre(), gh.buscarHeroe("Capitán América").getNombre());
        assertEquals("Spider-Man", gh.buscarHeroe("Spider-Man").getNombre());
        assertEquals(capitanAmerica, gh.buscarHeroe("Capitán América"));
        assertNotNull(gh.buscarHeroe("Spider-Man"));
    }
}
