import java.util.ArrayList;
import java.util.HashMap;

public class Calculos {
    public static ArrayList<String> calcular(String referencia, int metroscubicos) throws Exception{
        double pretotal = 0;
        double unidades = 0;
        double preciom = 0;
        HashMap<String,Tablon> lista = Catalogo.listado();
        Tablon tablonref = lista.get(referencia);

        int largo = tablonref.largo;
        int ancho = tablonref.ancho;
        int alto = tablonref.alto;
        double precio = tablonref.precio;
        if ((alto*ancho*largo) == 0) {
            throw new Exception("No puedes dividir por 0");
        }
        unidades = ((double)metroscubicos * 1000000000)/((alto*ancho*largo));
        pretotal = unidades * precio;
        if (metroscubicos <= 0) {
            throw new Exception("No puedes poner m3 de 0 o menos");
        }
        preciom = pretotal/metroscubicos;

        ArrayList<String> salida = new ArrayList<String>();

        salida.add("Precio total: " + String.format("%.2f", pretotal)+"€");
        salida.add("Unidades: " + (int)unidades);
        salida.add("Precio por m3: " + String.format("%.2f", preciom)+"€");

        return salida;
    }
    public static boolean existe(String referencia) throws Exception{

        HashMap<String,Tablon> lista = Catalogo.listado();
        Tablon tablonref = lista.get(referencia);

        if (tablonref == null) {
            throw new Exception("No e encontrado la referencia");
        }

        return true;
    }
}