public class pru {
    public static int[] ordenar(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int pv = array.length - 1;
        int naranja = -1;

        for (int i = 0; i < pv; i++) {
            if (array[i] <= array[pv]) {
                naranja += 1;
                if (array[i] < array[naranja]) {
                    // Swap
                    int temp = array[i];
                    array[i] = array[naranja];
                    array[naranja] = temp;
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
    }

    public static void main(String[] args) {
        // ... (código anterior)

        int [] arr = {3,2,5,0,1,8,7,6,9,4};
        int [] ar = ordenar(arr);

        // Copiar el array ordenado en un nuevo array
        int[] arrayOrdenado = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            arrayOrdenado[i] = ar[i];
        }

        // Imprimir el array copiado
        System.out.println("Copia del array ordenado:");
        for (int i = 0; i < arrayOrdenado.length; i++) {
            System.out.print(arrayOrdenado[i] + " ");
        }
        System.out.println();
    }
}
