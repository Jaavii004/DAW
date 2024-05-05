package org.antonio;

import static org.junit.Assert.*;

import org.antonio.Exception.HeroeNoEncontradoException;
import org.antonio.Model.GestorHeroes;
import org.antonio.Model.Heroe;
import org.junit.Test;

public class TestActualizacionHeroe {
    
    @Test
    public void testActualizarHeroe() throws HeroeNoEncontradoException {
        GestorHeroes gh = new GestorHeroes();
        Heroe capitanAmerica = new Heroe("Capitán América", "Superfuerza, agilidad, resistencia", "Soldado de la Segunda Guerra Mundial", "descripcion");
        gh.agregarHeroe(capitanAmerica);
        
        capitanAmerica.setNombre("Capitan America");
        capitanAmerica.setSuperpoderes("ninguno");
        capitanAmerica.setBiografia("soldado");
        capitanAmerica.setDescripcion("Descripcion");

        assertEquals("Capitan America", capitanAmerica.getNombre());
        assertEquals("ninguno", capitanAmerica.getSuperpoderes());
        assertEquals("soldado", capitanAmerica.getBiografia());
        assertEquals("Descripcion", capitanAmerica.getDescripcion());
        assertNotEquals("Capitán América", capitanAmerica.getNombre());
        assertNotEquals("Superfuerza, agilidad, resistencia", capitanAmerica.getSuperpoderes());
        assertNotEquals("Soldado de la Segunda Guerra Mundial", capitanAmerica.getBiografia());
        assertNotEquals("descripcion", capitanAmerica.getDescripcion());
    }
}
