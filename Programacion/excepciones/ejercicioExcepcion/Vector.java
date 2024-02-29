public class Vector {
    public static void main(String[] args) {
        int[] vector = new int[5];

        try {
            vector[0] = 0;
            vector[1] = 1;
            vector[2] = 2;
            vector[3] = 3;
            if (vector[3] != 0) {
                throw new Exception("No puedes añadir nada a 3.");
            }
            vector[4] = 4;
            vector[5] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Estás fuera del rango");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}