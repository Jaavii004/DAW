package lib;

public class Cortesia {
    public static String saludo(String idioma, String nombre) {
        String saludo = "ERROR";
        if (idioma.equals("ES")) {
            saludo="Estimado "+nombre;
        }
        if (idioma.equals("EN")) {
            saludo="Dear "+nombre;
        }
        if (idioma.equals("FR")) {
            saludo="Cher "+nombre;
        }
        return saludo;
    }
    public static String despedida(String idioma) {
        String saludo = "ERROR";
        if (idioma.equals("ES")) {
            saludo="Saludos cordiales";
        }
        if (idioma.equals("EN")) {
            saludo="Best regards";
        }
        if (idioma.equals("FR")) {
            saludo="Bien cordialement";
        }
        return saludo;
    }
}
