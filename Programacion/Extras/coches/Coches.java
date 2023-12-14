public class Coches {
    public static void main(String[] arg) {
        char[] cocheprim = new char[20];
        char[] cocheseg = new char[20];
        boolean ganador = false;
        int NumCochePrim;
        int NumCocheSeg;
        // ICONO del coche
        //System.out.print("\uD83D\uDE97 ");
        //System.out.print("🚗 ");
        // ICONO del Arbol
        //System.out.print("🌳 ");

        // V va a ser vacio
        // C va a ser un coche
        // A va a ser arbol

        for (int i = 0; i < cocheprim.length-1; i++) {
            cocheprim[i] = 'V';
        }
        for (int i = 0; i < cocheseg.length; i++) {
            cocheprim[i] = 'V';
        }

        for (int i = 0; i < 5; i++) {
            int arbolprim = (int) (Math.random() * 17)+1;
            while (cocheprim[arbolprim] == 'V') {
                arbolprim = (int) (Math.random() * 17)+1;
                
            }
            cocheprim[arbolprim] = 'A';

        }
        cocheprim[19] = 'C';
        cocheseg[19] = 'C';

        for (int i = 0; i < cocheprim.length; i++) {
            //System.out.println("05");
            if (cocheprim[i] == 'A') {
                //System.out.print("A ");
                System.out.print("🌳");
            }
            if (cocheprim[i] == 'C') {
                //System.out.print("C ");
                System.out.print("🚗");
            }
            if (cocheprim[i] == 'V') {
                System.out.print("_ ");
            }
        }
        System.out.println(" ");
        int posicocheprim = 19;

        do {
            NumCochePrim = (int) (Math.random() * 4);
            NumCocheSeg = (int) (Math.random() * 4);
            int cocheprimnum = posicocheprim - NumCochePrim;
            cocheprim[cocheprimnum] = 1;
            
            System.out.println("1 ");

            ganador = true;

            if (cocheprim[0] == 1) {
                ganador = true;
                System.out.print("A ");
            }
        } while (!ganador);
    }
}
