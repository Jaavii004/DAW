public class QuickSort {
    
    public static int[] ordenar(int[] array) {
        // Salgo si es 1 o menos en el array
        if (array.length <= 1) {
            return array;
        }
        int pv = array.length - 1;
        int naranja = -1;
        int temp = 0;
        for (int i = 0; i < pv; i++) {
            temp = array[i];
            if (temp <= array[pv]) {
                naranja += 1;
                if (temp < array[naranja]) {
                    array[i] = array[naranja];
                    array[naranja] = temp;
                }
            }
        }

        // colocar el pv al final
        temp = array[pv];
        array[pv] = array[naranja + 1];
        array[naranja + 1] = temp;

        // ordenar la lista antes y despues del pv
        int[] antes = new int[naranja + 1];
        int[] despues = new int[array.length - naranja - 2];

        for (int i = 0; i <= naranja; i++) {
            antes[i] = array[i];
        }
        int temp2 = naranja + 2;
        for (int j = 0; temp2 < array.length; j++) {
            despues[j] = array[temp2];
            temp2++;
        }
        // recursivamente ordenar
        antes = ordenar(antes);
        despues = ordenar(despues);

        // Juntarlas en array para mostrarlas
        for (int i = 0; i < antes.length; i++) {
            array[i] = antes[i];
        }
        array[antes.length] = array[naranja + 1];
        naranja += 2;
        for (int i = 0; i < despues.length; i++) {
            array[naranja] = despues[i];
            naranja++;
        }

        return array;
        //antes = new int[pv];
        //for (int i = 0; i < pv; i++) {
        //    antes[i] = array[i];
        //}
        //ordenar(antes);
        //int hastdond = array.length-pv;
        //despues = new int[hastdond];
        //for (int i = 0; i < hastdond; i++) {
        //    despues[i] = array[i];
        //}
        //ordenar(despues);
        //for (int i = 0; i < naranja; i++) {
        //    array[i] = antes[i];
        //}
        //for (int i = 1; i < hastdond; i++) {
        //    array[i] = despues[i];
        //}
        ////for (int i = 0; i < array.length; i++) {
        ////    if (i> naranja) {
        ////        array[i]= antes[i];
        //    }
        //    if (i> naranja) {
        //        array[i]= despues[i];
        //    }
        //}
    }
    public static void main(String[] args) {
        int numeros = 10;
        int[] list = new int[numeros];

        for (int i = 0; i < numeros; i++) {
            list[i] = (int) (Math.random() * 100) +1;
        }
        System.out.println("Original:");
        for (int i = 0; i < numeros; i++) {
            System.out.print(list[i]+" ");
        }
        System.out.println();
        int [] ar = ordenar(list);
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i]+" ");
        }
        System.out.println();
    }
}
