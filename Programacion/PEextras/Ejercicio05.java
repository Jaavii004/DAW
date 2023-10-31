import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {
        String respuestaUsu;
        int i = 0;
        Scanner sc = new Scanner(System.in);
        int puntuacion = 0;
        String[] preguntas = {
            "¿Cuál es el lenguaje de programación que estamos aprendiendo?",
            "¿Quien nos da base de datos?",
            "¿Procesador de intel de server?",
            "¿Cuantas asignaturas tenemos?",
            "¿Como se llama nuestro profesor de programacion?",
            "¿Y el de entornos?",
            "¿Y el de lenguajes?",
            "¿?",
            "¿?",
            "¿?"
        };
        String[] respuestas = {
            "Java",
            "Nadie",
            "Xeon",
            "5",
            "Gines",
            "Antonio",
            "Manuel Maria",
            "",
            "",
            ""
        };

        while (i < 10) {
            System.out.print("\033[H\033[2J");
            System.out.print(preguntas[i]+" ");
            respuestaUsu = sc.nextLine();
            if (respuestaUsu.equalsIgnoreCase(respuestas[i])) {
                puntuacion++;
            }
            i++;
        }
        System.out.println("Has conseguido "+puntuacion+" puntos.");
    }
}