import java.util.Scanner;

// calculadora RPN (Notación Polaca Inversa).
public class CalculadoraRPNComentada {
    // Muestra los números almacenados en el array en orden inverso.
    public static void Mostrarstak(double[] array) {
        for (int i = array.length-1; i >= 0; i--) {
            String numerocon0 = String.format("%02d", (i+1));
            System.out.println(numerocon0 + ":  " + array[i]);
        }
        System.out.println("Pulsa q para salir");
    }

    /*
    // Calcula el número de elementos no nulos en un array de tipo double.
    public static int contRelleno(double[] array) {
        int relleno = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]!=0) {
                relleno +=1;
            } 
        }
        return relleno;
    }
    */

    // Guarda un número en el array, desplazando los demás números hacia la derecha.
    public static double[] guardar(double[] array,double numGuardar) {
        /*if (contRelleno(array)==array.length){
            System.out.println("ESTOY LLENO NO ME CABE MAS");
            return array;
        }
        */
        double[] arrayvolteado = new double[array.length];
        for (int i = 0; i < array.length-1; i++) {
            arrayvolteado[i+1] = array[i];
        }
        arrayvolteado[0] = numGuardar;
        return arrayvolteado;
    }

    // Guarda el resultado de una operación en el array, desplazando los demás números hacia la izquierda.
    public static double[] guardarResultados(double[] array,double numGuardar) {
        double[] arrayvolteado = new double[array.length];
        for (int i = 1; i < array.length-1; i++) {
            arrayvolteado[i-1] = array[i+1];
        }
        arrayvolteado[0] = numGuardar;
        return arrayvolteado;
    }

  /**
     * El método principal de la clase CalculadoraRPN.
     * Permite realizar operaciones aritméticas utilizando la notación polaca inversa (RPN).
     * Lee la entrada del usuario y muestra el resultado de las operaciones.
     * 
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario
        int num; // Variable para almacenar el número de elementos en el array
        boolean salir; // Variable para controlar el bucle principal
        String entrada = ""; // Variable para almacenar la entrada del usuario
        double resultado = 0; // Variable para almacenar el resultado de las operaciones
        boolean valid; // Variable para validar la entrada del usuario

        System.out.print("Numero entre 4 y 20: "); // Muestra un mensaje para solicitar al usuario un número entre 4 y 20
        num = sc.nextInt(); // Lee el número ingresado por el usuario
        double[] array = new double[num]; // Crea un array de tipo double con el tamaño especificado por el usuario

        salir = false; // Inicializa la variable salir como falsa
        sc.nextLine(); // Limpia el buffer del Scanner
        while (!salir) { // Bucle principal que se ejecuta mientras salir sea falso
            valid = false; // Inicializa la variable valid como falsa
            Mostrarstak(array); // Llama al método Mostrarstak para mostrar los números almacenados en el array

            System.out.print("Entrada: "); // Muestra un mensaje para solicitar al usuario una entrada
            entrada = sc.nextLine(); // Lee la entrada ingresada por el usuario

            if (entrada.matches("-?\\d+(\\.\\d+)?")) { // Verifica si la entrada es un número válido
                double numeroDouble = Double.parseDouble(entrada); // Convierte la entrada en un número de tipo double
                array = guardar(array, numeroDouble); // Llama al método guardar para almacenar el número en el array
            } else { // Si la entrada no es un número válido
                double num1 = array[0]; // Almacena el primer número del array en la variable num1
                double num2 = array[1]; // Almacena el segundo número del array en la variable num2

                if (entrada.equalsIgnoreCase("q")) { // Verifica si la entrada es "q" (para salir del programa)
                    salir = true; // Establece salir como verdadero para finalizar el bucle principal
                    valid = true; // Establece valid como verdadero para evitar mostrar el mensaje de opción no válida
                }

                if (entrada.equalsIgnoreCase("+")) { // Verifica si la entrada es "+"
                    resultado = num1 + num2; // Realiza la operación de suma
                    array = guardarResultados(array, resultado); // Llama al método guardarResultados para almacenar el resultado en el array
                    valid = true; // Establece valid como verdadero para evitar mostrar el mensaje de opción no válida
                }

                if (entrada.equalsIgnoreCase("*")) { // Verifica si la entrada es "*"
                    resultado = num1 * num2; // Realiza la operación de multiplicación
                    array = guardarResultados(array, resultado); // Llama al método guardarResultados para almacenar el resultado en el array
                    valid = true; // Establece valid como verdadero para evitar mostrar el mensaje de opción no válida
                }

                if (entrada.equalsIgnoreCase("/")) { // Verifica si la entrada es "/"
                    resultado = num2 / num1; // Realiza la operación de división
                    array = guardarResultados(array, resultado); // Llama al método guardarResultados para almacenar el resultado en el array
                    valid = true; // Establece valid como verdadero para evitar mostrar el mensaje de opción no válida
                }

                if (entrada.equalsIgnoreCase("-")) { // Verifica si la entrada es "-"
                    resultado = num2 - num1; // Realiza la operación de resta
                    array = guardarResultados(array, resultado); // Llama al método guardarResultados para almacenar el resultado en el array
                    valid = true; // Establece valid como verdadero para evitar mostrar el mensaje de opción no válida
                }

                if (!valid) { // Si la entrada no es válida
                    System.out.println("Opcion no valida"); // Muestra un mensaje de opción no válida
                }
            }
        }
        sc.close(); // Cierra el objeto Scanner
    }
    // Este código implementa una calculadora RPN (Notación Polaca Inversa) que permite realizar operaciones matemáticas básicas utilizando un array como pila.
}