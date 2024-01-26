package Programacion.orientadaAObjetos;

import lib.mesa;

public class PruebaMesa {
    public static void main(String[] args) {
        mesa miMesa = new mesa();
        System.out.println("Color inicial mesa: "+miMesa.getColor());
        miMesa.setcol("amarillo");
        System.out.println("Nuevo color :"+ miMesa.getColor());
        System.out.println("-----");

        mesa otraMesa = new mesa("Azul", 3, 50,60,"Acero");
        System.out.println("color otraMesa: "+otraMesa.getColor());
        System.out.println("Area: "+ otraMesa.area());
        System.out.println("Area: "+ otraMesa.area("m"));
        System.out.println("Area: "+ otraMesa.area("in"));
    }
}