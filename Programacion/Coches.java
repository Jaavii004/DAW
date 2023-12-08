public class Coches {
    public static void main(String[] arg) {
        int[] cocheprim = new int[20];
        int[] cocheseg = new int[20];
        boolean ganador = false;
        int NumCochePrim;
        int NumCocheSeg;

        // 2 va a ser vacio
        // 1 va a ser un coche
        // 0 va a ser arbol

        for (int i = 0; i < cocheprim.length-1; i++) {
            cocheprim[i] = 2;
        }
        for (int i = 0; i < cocheseg.length; i++) {
            cocheprim[i] = 2;
        }

        for (int i = 0; i < 5; i++) {
            int arbolprim = (int) (Math.random() * 17)+1;
            while (cocheprim[arbolprim] == 0) {
                arbolprim = (int) (Math.random() * 17)+1;
                cocheprim[arbolprim] = 0;
            }
            cocheprim[arbolprim] = 0;

        }
        cocheprim[19] = 1;
        cocheseg[19] = 1;

        for (int i = 0; i < cocheprim.length; i++) {
            if (cocheprim[i] == 0) {
                System.out.print("A ");
            }
            if (cocheprim[i] == 1) {
                System.out.print("C ");
            }
            if (cocheprim[i] == 2) {
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

            //*****if (piedras != 0) {
            //    veces = 1;
            //    while (piedras >= veces) {
            //        piedras -= veces;
            //        veces++;
            //    }
            //    veces--;
                System.out.println(" ");
            //    piedras=1;
            //}
            if (cocheprim[0] == 0) {
                ganador = true;
                System.out.print("A ");
            }
        } while (!ganador);
    }
}
