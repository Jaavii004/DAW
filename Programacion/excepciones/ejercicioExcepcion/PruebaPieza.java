public class PruebaPieza {
    @SuppressWarnings("removal")
    public static void main(String[] args) {
        Pieza p1 = new Pieza("cuadrado","rojo");
        Pieza p2 = new Pieza("cuadrado","rojo");

        Double d;
        String k;
        boolean b1;
        boolean b2;
        boolean b3;
        boolean b4;

        try {
            d = new Double(1.0);
            k = "Hola";
            b1 = p1.equals(p2);
            System.out.println(b1);
            b2 = d.equals(k);
            System.out.println(b2);
            b3 = k.equals(p2);
            System.out.println(b3);
            b4 = p1.equals(d);
            System.out.println("b4 "+b4);
        } catch (ClassCastException e) {
            System.out.println("Error no puedo comprar un doble con una Pieza.");
        }
    }
}