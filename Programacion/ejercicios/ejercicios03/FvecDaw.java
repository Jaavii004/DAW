package ejercicios03;

public class FvecDaw {
    // Función GenerarArray: Genera un array de tamaño n con números aleatorios cuyo intervalo (mínimo y máximo) se indica como parámetro.
    public static int[] generarArrayInt(int n, int numMax, int numMin) {
        int[] arrayale = new int[n];
        int random;
        for (int i = 0; i < n; i++) {
            random = (int) (Math.random() * (numMax-numMin+1)+numMin);
            arrayale[i] = random;
        }
        return arrayale;
    }

    // Función minimoArrayInt: Devuelve el mínimo del array que se pasa como parámetro.
    public static int minimoArrayInt(int[] array) {
        int min;
        min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min =  array[i];
            }
        }
        return min;
    }

    // Función maximoArrayInt: Devuelve el máximo del array que se pasa como parámetro.
    public static int maximoArrayInt(int[] array) {
        int max;
        max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max =  array[i];
            }
        }
        return max;
    }

    // Función mediaArrayInt: Devuelve la media del array que se pasa como parámetro.
    public static int mediaArrayInt(int[] array) {
        int suma = 0;
        int media = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        media = suma/array.length;
        return media;
    }

    // Función estaEnArrayInt: Dice si un número está o no dentro de un array.
    public static boolean estaEnArrayInt(int[] array, int n) {
        boolean esta = false;
        for (int i = 0; i < array.length; i++) {
            if (n == array[i]) {
                esta = true;
            }
        }
        return esta;
    }

    // Función posicionEnArray: Busca un número en un array y devuelve la posición (el índice) en la que se encuentra.
    public static int posicionEnArray(int[] array, int n) {
        int encontrado = -1;
        for (int i = 0; i < array.length; i++) {
            if (n == array[i]) {
                encontrado = i;
                i = (array.length+1);
            }
        }
        return encontrado;
    }

    // Función volteaArray: Le da la vuelta a un array.
    public static int[] volteaArray(int[] array) {
        int[] numVolteado = new int[array.length];
        int i = 0;
        for (int o = array.length-1; o >= 0; o--) {
            numVolteado[i] = array[o];
            i++;
        }
        return numVolteado;
    }


    public static void main(String[] args) {
        int[] array = generarArrayInt(10, 9, 40);
        System.out.print("generarArrayInt: ");
        for (int i = 0; i < 10; i++){
            System.out.print(array[i]+ " ");
        }
        System.out.println();

        int min = minimoArrayInt(array);
        System.out.println("minimoArrayInt: "+min);

        int max = maximoArrayInt(array);
        System.out.println("maximoArrayInt: "+max);

        int media = mediaArrayInt(array);
        System.out.println("mediaArrayInt: "+media);

        boolean esta = estaEnArrayInt(array,25);
        System.out.println("estaEnArrayInt: "+esta);

        int posicion = posicionEnArray(array, 12);
        System.out.println("posicionEnArray: "+posicion);

        System.out.print("volteaArray: ");
        int[] volteado = volteaArray(array);
        for (int i = 0; i < volteado.length; i++){
            System.out.print(volteado[i]+" ");
        }
        System.out.println();
    }
}
