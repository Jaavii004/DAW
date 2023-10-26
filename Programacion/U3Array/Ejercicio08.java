
public class Ejercicio08 {
    public static void main(String[] args) {
        int[][] num = new int[8][6];
        for (int i = 0; i < 8; i++) {
            if (i == 0 || i == 7){
                for (int j = 0; j < 6 ; j++) {
                    num [i][j] = 1;
                }
            }else{
                for (int j = 0; j < 6 ; j++) {
                    if (j == 0 || j == 5){
                        num [i][j] = 1;
                    }else{
                        num [i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(num[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
