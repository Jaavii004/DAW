public class quik {
    public static int[] ordenar(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int pv = array.length-1;
        // verde = i
        int naranja = -1;
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            num = array[i];
            System.out.println("*** num= "+num+"pv<="+pv);
            if (num <= array[pv]) {
                naranja += 1;
                System.out.println("nara+1 "+naranja);
                System.out.println("num= "+num+" nara>"+array[naranja]);
                if (num < array[naranja]) {
                    System.out.println("Cambiado naranja ="+array[naranja]+"verde= "+num);
                    array[i] = array[naranja];
                    array[naranja] = num;

                }
            }
        }


        // Swap para colocar el pivote en su posición final
        int temp = array[pv];
        array[pv] = array[naranja + 1];
        array[naranja + 1] = temp;

        // Recursivamente ordena las sublistas antes y después del pivote
        int[] antes = new int[naranja + 1];
        int[] despues = new int[array.length - naranja - 2];

        for (int i = 0; i <= naranja; i++) {
            antes[i] = array[i];
        }
        for (int i = naranja + 2, j = 0; i < array.length; i++, j++) {
            despues[j] = array[i];
        }

        antes = ordenar(antes);
        despues = ordenar(despues);

        // Combina las sublistas ordenadas
        for (int i = 0; i < antes.length; i++) {
            array[i] = antes[i];
        }
        array[antes.length] = array[naranja + 1];
        for (int i = 0, j = naranja + 2; i < despues.length; i++, j++) {
            array[j] = despues[i];
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
//
//
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
        int [] arr = {3,2,5,0,1,8,7,6,9,4};
        System.out.println();
        int [] ar = ordenar(arr);
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i]+" ");
        }
        System.out.println();
    }

}