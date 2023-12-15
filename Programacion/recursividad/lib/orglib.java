package lib;

public class orglib {
    public static int escalado(String[][] array, int empleado, int niveljefe) {
        int nivjefe = 0;
        int ent = 0;
        int jefe = 0;
        for (int i = 0; i < array.length; i++) {
            int num = Integer.parseInt(array[i][0]);
            if (num == empleado) {
                nivjefe = Integer.parseInt(array[i][2]);
                jefe = Integer.parseInt(array[i][3]);
            }
        }
        if (nivjefe == niveljefe) {
            ent = empleado;
        } else {
            ent = escalado(array, jefe, niveljefe);
        }
        return ent;
    }
}
