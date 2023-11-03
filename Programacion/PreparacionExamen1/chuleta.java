public class ChuletaJava {
    public static void main(String[] args) {
        // Estructura básica de un programa Java
        System.out.println("Hola, mundo!");
        
        // Declaración y asignación de variables
        int numero = 10;
        String texto = "Hola, mundo!";
        
        // Operadores básicos
        int suma = 5 + 3;
        int resta = 10 - 2;
        int multiplicacion = 4 * 6;
        int division = 8 / 2;
        int modulo = 7 % 3;
        
        // Estructuras de control
        if (numero > 5) {
            System.out.println("El número es mayor que 5");
        } else {
            System.out.println("El número no es mayor que 5");
        }
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteración " + i);
        }
        
        int contador = 0;
        while (contador < 3) {
            System.out.println("Contador: " + contador);
            contador++;
        }
        
        // Arreglos (arrays)
        int[] numeros = {1, 2, 3, 4, 5};
        String[] frutas = new String[3];
        frutas[0] = "manzana";
        frutas[1] = "banana";
        frutas[2] = "naranja";
        
        // Métodos (funciones)
        int resultadoSuma = suma(5, 3);
        System.out.println("Resultado de la suma: " + resultadoSuma);
        saludar();
        
        // Clases y objetos
        Persona persona = new Persona("Juan", 30);
        persona.saludar();
    }
    
    public static int suma(int a, int b) {
        return a + b;
    }
    
    public static void saludar() {
        System.out.println("Hola, soy una función.");
    }
}

class Persona {
    String nombre;
    int edad;
    
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }
}