import java.util.Scanner;

public class Ejer02 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p;
		int h;
		String numPh;
		String numhabita;
		int numhabitacompro;
		int habita;
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
		// Habitaciones que comprobaremos
		numhabitacompro  = sc.nextInt();
		for (int o = 0; o < numhabitacompro; o++) {
			habita = sc.nextInt();
			int planta = habita/100;
			int habitacion = habita%100;
			if (habitaciones[planta-1][habitacion-1] == 0){
				System.err.println(habita+" LIBRE");
			}
			if (habitaciones[planta-1][habitacion-1] == 1){
				System.err.println(habita+" RESERVADA");
			}
			if (habitaciones[planta-1][habitacion-1] == 2){
				System.err.println(habita+" OCUPADA");
			}
		}
		sc.close();
	}
}
