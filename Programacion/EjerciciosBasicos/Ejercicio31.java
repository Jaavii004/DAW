public class Ejercicio31 {
    public static void main(String[] args) {
        int a = 8;
        int b = 3;
        int c = -5;
        int resulta = a + b + c;
        System.out.println("a + b + c = "+resulta);
        int resultb = 2 * b + 3* (a - c); 
        System.out.println("2 * b + 3 * (a - c) = "+resultb);
    
        int resultc = a / b; 
        System.out.println("a / b = "+resultc);
    
        int resultd = a % b; 
        System.out.println("a % b = "+resultd);
        
        int resulte = a / c; 
        System.out.println("a / c = "+resulte);
        
        int resultf = a % c; 
        System.out.println("a % c = "+resultf);
        
        int resultg = a * b / c; 
        System.out.println("a * b / c = "+resultg);
        int resulth = a * (b / c); 
        System.out.println("a * (b / c = "+resulth);
        int resulti = a * c % b; 
        System.out.println("a * c % b = "+resulti);
        int resultj = (a - 3 * b) % (c + 2 * a) / (a - c); 
        System.out.println("(a - 3 * b) % (c + 2 * a) / (a - c) = "+resultj);
        int resultk = a - b - c * 2; 
        System.out.println("a - b - c * 2 = "+resultk);
    }
}
