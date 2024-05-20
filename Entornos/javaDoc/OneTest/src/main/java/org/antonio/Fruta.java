package org.antonio;

/**
 * La clase Fruta representa una fruta con un nombre y una propiedad que indica si es deliciosa o no.
 * @version 1.0
 */
public class Fruta {
    private String nombre;
    private boolean esDeliciosa;

    /**
     * Construye un objeto Fruta con el nombre y la deliciosidad especificados.
     *
     * @param nombre       el nombre de la fruta
     * @param esDeliciosa  true si la fruta es deliciosa, false en caso contrario
     */
    public Fruta(String nombre, boolean esDeliciosa) {
        this.nombre = nombre;
        this.esDeliciosa = esDeliciosa;
    }

    /**
     * Devuelve el nombre de la fruta.
     *
     * @return el nombre de la fruta
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Comprueba si la fruta es deliciosa.
     *
     * @return true si la fruta es deliciosa, false en caso contrario
     */
    public boolean esDeliciosa() {
        return esDeliciosa;
    }

    /**
     * Comprueba si la fruta se puede comer.
     * Una fruta se puede comer si es deliciosa y su nombre no es "Fruta del Diablo".
     *
     * @return true si la fruta se puede comer, false en caso contrario
     */
    public boolean puedoComer() {
        return esDeliciosa && !nombre.equals("Fruta del Diablo");
    }
}
