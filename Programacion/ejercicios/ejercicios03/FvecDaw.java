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

    // Función GenerarArray:
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

    public static void main(String[] args) {
        int[] contador = generarArrayInt(10, 9, 20);
        for (int i = 0; i < 10; i++){
            System.out.print(" " + contador[i]);
        }

        int compu = minimoArrayInt(contador);
        System.out.println("/n " + compu);
    }
}

