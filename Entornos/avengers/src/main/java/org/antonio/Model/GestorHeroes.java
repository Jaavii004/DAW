package org.antonio.Model;

import org.antonio.Exception.HeroeNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class GestorHeroes {
    private List<Heroe> heroes;

    public GestorHeroes() {
        this.heroes = new ArrayList<>();
    }

    public void agregarHeroe(Heroe heroe) {
        this.heroes.add(heroe);
    }

    public Heroe buscarHeroe(String nombre) throws HeroeNoEncontradoException {
        for (Heroe heroe : this.heroes) {
            if (heroe.getNombre().equals(nombre)) {
                return heroe;
            }
        }
        throw new HeroeNoEncontradoException(nombre);
    }

    public List<Heroe> getHeroes() {
        return heroes;
    }

    public void eliminarHeroe(String nombre) throws HeroeNoEncontradoException {
        Heroe eliHeroe = buscarHeroe(nombre);
        this.heroes.remove(eliHeroe);
    }

    public Heroe buscarHeroePorSuperpoder(String superpoder) throws HeroeNoEncontradoException {
        for (Heroe heroe : this.heroes) {
            String superpoderes = heroe.getSuperpoderes();
            if (superpoderes.contains(superpoder)) {
                return heroe;
            }
        }
        throw new HeroeNoEncontradoException("No se encontró ningún héroe con el superpoder: " + superpoder);
    }

    public void actualizarHeroe(Heroe heroeActualizado) throws HeroeNoEncontradoException {
        Heroe heroeExistente = buscarHeroe(heroeActualizado.getNombre());
        int index = heroes.indexOf(heroeExistente);
        heroes.set(index, heroeActualizado);
    }

    public String listarHeroes() {
        String Nombres = "";
        for (Heroe heroe : this.heroes) {
            Nombres += heroe.getNombre();
            if (heroe != this.heroes.get(this.heroes.size() - 1)) {
                Nombres += ", ";
            }
        }
        return Nombres;
    }

    public List<Heroe> buscarHeroesPorSuperpoder(String superpoderes) {
        List<Heroe> ListHeroes = new ArrayList<>();
        for (Heroe heroe : this.heroes) {
            String superpoderesHeroe = heroe.getSuperpoderes();
            if (superpoderesHeroe.contains(superpoderes)) {
                ListHeroes.add(heroe);
            }
        }
        return ListHeroes;
    }
}
