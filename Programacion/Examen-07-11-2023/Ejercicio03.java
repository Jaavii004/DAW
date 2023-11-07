public class Ejercicio03 {
    public static void main(String[] args) {
        int fila;
        int columna;
        char[][] minas = new char[20][20];
        // Inicializar matriz
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                minas[i][j] = '_';
            }
        }
        for (int i = 0; i < 50; i++) {
            boolean salir = false;
            do{
                fila = (int) (Math.random() * 20);
                columna = (int) (Math.random() * 20);
                if (minas[columna][fila] == '_') {
                    if (fila != 0){
                        if (fila != 19){
                            if (minas[columna][fila-1] == '_' && minas[columna][fila+1] == '_' ){
                                minas[columna][fila] = '*';
                                salir = true;
                            }
                        }else{
                            if (minas[columna][fila-1] == '_'){
                                minas[columna][fila] = '*';
                                salir = true;
                            }
                        }
                    }
                }
            }while (!salir);
        }


        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(minas[i][j]);
            }
            System.out.println();
        }
    }
}
