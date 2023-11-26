package ejercicios03;

public class FvecDaw {
    // Función GenerarArray:
    public static int[] generarArrayInt(int n, int numMax, int numMin) {
        int[] arrayale = new int[n];
        int random;
        for (int i = 0; i < n; i++) {
            random = (int) (Math.random() * (numMax-numMin+1)+numMin);
            arrayale[i] = random;
        }
        return arrayale;
    }

    // Función minimoArrayInt:
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

    // Función maximoArrayInt:
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

    // Función mediaArrayInt:
    public static int mediaArrayInt(int[] array) {
        int suma = 0;
        int media = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        media = suma/array.length;
        return media;
    }

    // Función estaEnArrayInt:
    public static boolean estaEnArrayInt(int[] array, int n) {
        boolean esta = false;
        for (int i = 0; i < array.length; i++) {
            if (n == array[i]) {
                esta = true;
            }
        }
        return esta;
    }

    // Función posicionEnArray:
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

    public static void main(String[] args) {
        int[] contador = generarArrayInt(10, 9, 20);
        for (int i = 0; i < 10; i++){
            System.out.print(" " + contador[i]);
        }
        System.out.println();

        int min = minimoArrayInt(contador);
        System.out.println(min);

        int max = maximoArrayInt(contador);
        System.out.println(max);

        int media = mediaArrayInt(contador);
        System.out.println(media);

        boolean esta = estaEnArrayInt(contador,99);
        System.out.println(esta);

        int posicion = posicionEnArray(contador, 12);
        System.out.println(posicion);

    }
}

