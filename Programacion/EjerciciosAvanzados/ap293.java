import java.util.*;
class ap293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int numinsectos;
        int numiaracnidos;
        int numicrustaceos;
        int numiciempies;
        int numimilpies;
        int numisegmentosciempies;
        int numisegmentosmilpies;

        System.out.print("Numero de insectos = ");
        numinsectos = sc.nextInt();
        int patasinsectos = (numinsectos * 6);


        System.out.print("Numero de arácnidos = ");
        numiaracnidos = sc.nextInt();
        int patasaracnidos = (numiaracnidos * 8);


        System.out.print("Numero de crustáceos = ");
        numicrustaceos = sc.nextInt();
        int patascrustaceos = (numicrustaceos * 10);


        System.out.print("Numero de ciempiés = ");
        numiciempies = sc.nextInt();
        System.out.print("Numero de segmentos = ");
        numisegmentosciempies = sc.nextInt();
        int patasciempies = (numiciempies * numisegmentosciempies * 2);
        
        System.out.print("Numero de milpies = ");
        numimilpies = sc.nextInt();
        System.out.print("Numero de segmentos = ");
        numisegmentosmilpies = sc.nextInt();
        int patasmilpies = (numimilpies * numisegmentosmilpies * 4);
       
        int numitotal = patasaracnidos + patasciempies + patascrustaceos + patasinsectos + patasmilpies ;

        System.out.println("Numero total de patas es de "+numitotal);
    }
}