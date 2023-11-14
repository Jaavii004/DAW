import java.util.Scanner;

public class Ejer02 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p;
		int h;
		String numPh;
		String numhabita;
		int numhabitacompro;
		String habita;
		numPh = sc.nextLine();
		String numsepa[] = numPh.split(" ");
		p = Integer.parseInt(numsepa[0]);
		h = Integer.parseInt(numsepa[1]);
		int [][] habitaciones = new int[p][h];
			
		for (int i = 0; i < p; i++) {
			//System.out.println("Planta"+i);
			numhabita = sc.nextLine();
			String sepahabita[] = numhabita.split(" ");
			for (int j = 0; j < h; j++) {
				String recorre = sepahabita[j];
				int number = Integer.parseInt(recorre);
				//System.out.println("habi"+h);
				habitaciones[i][j] = number;
			}
		}
		System.out.println("habitaciones que comprobaremos ");
		// Habitaciones que comprobaremos
		numhabitacompro  = sc.nextInt();
		for (int o = 0; o < numhabitacompro; o++) {
			habita = sc.nextLine();
			//char primero = habita.charAt(1);
			//String segundo = habita.substring(1);
			//int numberseg = Integer.parseInt(segundo);

			//System.out.println(numberseg);
		}
		sc.close();
	}
}
