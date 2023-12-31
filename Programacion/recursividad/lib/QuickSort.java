package lib;
public class QuickSort {
    public static int[] quickSort(int[] array) {
        // Todo explicaco muy bien en el video de youtube
        // https://www.youtube.com/watch?v=WprjBK0p6rw
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
        antes = quickSort(antes);
        despues = quickSort(despues);

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
    }
}
