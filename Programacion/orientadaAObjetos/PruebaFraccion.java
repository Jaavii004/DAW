import lib.Fraccion;

public class PruebaFraccion {
    public static void main(String[] args) {
        // Crear una fracción con valores iniciales
        Fraccion fraccion = new Fraccion();
        System.out.println("Fracción original: " + fraccion.getNumerador() + "/" + fraccion.getDenominador());
        
        // Crear una fracción con ortos datos
        fraccion.setNumerador(3);
        fraccion.setDenominador(7);
        System.out.println("Fracción modificada: " + fraccion.getNumerador() + "/" + fraccion.getDenominador());

        // Simplificar la fracción
        //fraccion.Simplificar();
        System.out.println("Fracción simplificada: " + fraccion.getNumerador() + "/" + fraccion.getDenominador());

        // Multiplicar la fracción por 2
        //fraccion.Multiplicar(2, 2);
        System.out.println("Fracción multiplicada por 2: " + fraccion.getNumerador() + "/" + fraccion.getDenominador());

        // Dividir la fracción por 3
        fraccion.Dividir(11,4);
        System.out.println("Fracción dividida : " + fraccion.getNumerador() + "/" + fraccion.getDenominador());

        
    }
}
