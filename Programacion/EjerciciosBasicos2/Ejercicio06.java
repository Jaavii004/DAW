class Ejercicio06 {
    public static void main(String[] args) {
        String[] nombrec = "Javier Puertas Rosello".split(" ");
        String nombre = nombrec[0];
        String primerape = nombrec[1];
        String segundoape = nombrec[2];

        System.out.println(nombre+" tiene una longitud de "+nombre.length());
        System.out.println(primerape+" tiene una longitud de "+primerape.length());
        System.out.println(segundoape+" tiene una longitud de "+segundoape.length());
    }
}
