import java.util.Scanner;

public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();

        for (int i = 0; i < casos; i++) {
            int n = sc.nextInt();
            boolean coor = true;
            int prv = sc.nextInt();
            int act;
            for (int j = 0; j < n-1; j++) {
                act = sc.nextInt();
                if (Math.abs(act) < Math.abs(prv)) {
                    if (prv*act < 0) {
                        coor = false;
                        break;
                    }
                } else {
                    if (prv*act > 0) {
                        coor = false;
                        break;
                    }
                }
                prv = act;
            }
            
            if (coor) {
                System.out.println("CORRECTA");
            } else {
                System.out.println("INCORRECTA");
            }
        }
        sc.close();
    }
}