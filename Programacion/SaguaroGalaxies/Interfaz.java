import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {
        HashMap<String, Galaxy> galaxy = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        File f = new File("SAC.bin");
        // DESERIALIZAMOS OBJETOS
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            boolean acabar = true;
            while (acabar) {
                try {
                    Galaxy gal = (Galaxy) ois.readObject();
                    System.out.println(gal.OBJECT);
                    galaxy.put(gal.OBJECT, gal);
                } catch (EOFException e) {
                    acabar = false;
                } catch (ClassNotFoundException e) {
                    System.out.println("");
                }
            }
            ois.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Excepción: " + e.getMessage());
        }
        boolean salir = false;
        String opcion = "";
        String obj;
        Galaxy gala;
        while (!salir) {
            System.out.println("Menu:");
            System.out.println("N. Nombre del objeto");
            System.out.println("C. Constelación");
            System.out.println("M. Magnitud límite");
            System.out.println("S. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "N":
                    try {
                        System.out.print("Dime el objeto: ");
                        obj = sc.nextLine();
                        gala = galaxy.get(obj);
                        System.out.println("- OBJECT: "+gala.OBJECT);
                        System.out.println("- CON: "+gala.CON);
                        System.out.println("- RA: "+gala.RA);
                        System.out.println("- DEC: "+gala.DEC);
                        System.out.println("- MAG: "+gala.MAG);
                    } catch (NullPointerException e) {
                        System.out.println("** El objeto no existe** ");
                    }
                    break;
            
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        }
        sc.close();
    }
}