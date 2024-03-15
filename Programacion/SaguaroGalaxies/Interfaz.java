import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {
        HashMap<String, Galaxy> galaxy = new HashMap<>();
        ArrayList<Galaxy> galaxyList = new ArrayList<>(galaxy.values());
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
                    galaxyList.add(gal);
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
        String constelacion;
        System.out.print("\033[H\033[2J");
        while (!salir) {
            System.out.println("Menu:");
            System.out.println("N. Nombre del objeto");
            System.out.println("C. Constelación");
            System.out.println("M. Magnitud límite");
            System.out.println("S. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextLine();
            boolean constNoEnc = false;
            double limimag;
            switch (opcion) {
                case "N":
                    try {
                        System.out.print("Dime el objeto: ");
                        obj = sc.nextLine();
                        gala = galaxy.get(obj);
                        System.out.println();
                        System.out.println("- OBJECT: " + gala.OBJECT);
                        System.out.println("- CON: " + gala.CON);
                        System.out.println("- RA: " + gala.RA);
                        System.out.println("- DEC: " + gala.DEC);
                        System.out.println("- MAG: " + gala.MAG);
                        System.out.println();
                    } catch (NullPointerException e) {
                        System.out.println("** El objeto no existe ** ");
                    }
                    break;
                case "C":
                    System.out.print("Dime la constelación: ");
                    constelacion = sc.nextLine();
                    System.out.println("---------------------------");
                    for (Galaxy gali : galaxyList) {
                        if (gali.CON.equals(constelacion)) {
                            constNoEnc = true;
                            System.out.println("- OBJECT: " + gali.OBJECT);
                            System.out.println("- CON: " + gali.CON);
                            System.out.println("- RA: " + gali.RA);
                            System.out.println("- DEC: " + gali.DEC);
                            System.out.println("- MAG: " + gali.MAG);
                            System.out.println("---------------------------");
                        }
                    }
                    if (!constNoEnc) {
                        System.out.println("** No existe esa constelación **");
                    }
                    break;
                case "M":
                    System.out.print("Dime la magnitud límite: ");
                    try {
                        limimag = sc.nextDouble();
                        // InputMismatchException
                        System.out.println("---------------------------");
                        for (Galaxy gali : galaxyList) {
                            if (Double.parseDouble(gali.MAG) <= limimag) {
                                System.out.println("- OBJECT: " + gali.OBJECT);
                                System.out.println("- CON: " + gali.CON);
                                System.out.println("- RA: " + gali.RA);
                                System.out.println("- DEC: " + gali.DEC);
                                System.out.println("- MAG: " + gali.MAG);
                                System.out.println("---------------------------");
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("** El numero debe ser con \",\"**");
                    }
                    sc.nextLine();
                    break;
                case "S":
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
        sc.close();
    }
}