package org.antonio;

import static org.junit.Assert.*;

import org.antonio.Exception.HeroeNoEncontradoException;
import org.antonio.Model.GestorHeroes;
import org.antonio.Model.Heroe;
import org.junit.Test;

public class TestActualizarHeroe {
    @Test
    public void testActualizarHeroe() throws HeroeNoEncontradoException{
        GestorHeroes gh = new GestorHeroes();
        Heroe ironman = new Heroe("Iron Man", "Traje de alta tecnología", "Millonario y filántropo", "descripcion");
        Heroe spiderman = new Heroe("Spider-Man", "Sentido arácnido, trepador", "Tímido estudiante de secundaria", "descripcion");
        Heroe capitanAmerica = new Heroe("Capitán América", "Superfuerza, agilidad, resistencia", "Soldado de la Segunda Guerra Mundial", "descripcion");

        Heroe capitanAmerica2 = new Heroe("Capitán América", "Superfuerza, agilidad, resistencia2", "Soldado de la Segunda Guerra Mundial2", "descripcion2");
        gh.agregarHeroe(capitanAmerica);
        gh.agregarHeroe(spiderman);
        gh.agregarHeroe(ironman);
        gh.actualizarHeroe(capitanAmerica2);

        assertEquals("Superfuerza, agilidad, resistencia2", gh.buscarHeroe("Capitán América").getSuperpoderes());
        assertEquals("Soldado de la Segunda Guerra Mundial2", gh.buscarHeroe("Capitán América").getBiografia());
        assertEquals("descripcion2", gh.buscarHeroe("Capitán América").getDescripcion());
        assertNotEquals("Superfuerza, agilidad, resistencia", gh.buscarHeroe("Capitán América").getSuperpoderes());
        assertNotEquals("Soldado de la Segunda Guerra Mundial", gh.buscarHeroe("Capitán América").getBiografia());
        assertNotEquals("descripcion", gh.buscarHeroe("Capitán América").getDescripcion());
    }
}
