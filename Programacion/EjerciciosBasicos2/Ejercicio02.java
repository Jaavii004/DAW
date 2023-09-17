class Ejercicio02 {
    public static void main(String[] args) {
        float a = 8.0f;
        int b = 3;
        char c = '5';
        //int result;
        //double resdubel;
        int resint = (int)(a-b+c);
        double resdouble = (a-b+c);
        System.out.println("a - b + c = "+(a - b + c)+ " resint = "+resint+" resdouble = "+resdouble);

        int resintb = (int)(2 * b + 3 * (a - c));
        double resdoubleb = (2 * b + 3 * (a - c));
        System.out.println("2 * b + 3 * (a - c) = "+(2 * b + 3 * (a - c))+ " resint = "+resintb+" resdouble = "+resdoubleb);

        int resintc = (int)(a / b);
        double resdoublec = (a / b);
        System.out.println("a / b = "+(a / b)+ " resint = "+resintc+" resdouble = "+resdoublec);


        int resintd = (int)(a % b);
        double resdoubled = (a % b);
        System.out.println("a % b = "+(a % b)+ " resint = "+resintd+" resdouble = "+resdoubled);

        int resinte = (int)(a / c - 2);
        double resdoublee = (a / c - 2);
        System.out.println("a / c - 2 = "+(a / c - 2)+ " resint = "+resinte+" resdouble = "+resdoublee);

        int resintf =  (int)(a * b / c);
        double resdoublef = (a * b / c);
        System.out.println("a * b / c = "+(a * b / c)+ " resint = "+resintf+" resdouble = "+resdoublef);

        int resintg = (int)(a * (c % b));
        double resdoubleg = (a * (c % b));
        System.out.println("a * (c % b) = "+(a * (c % b))+ " resint = "+resintg+" resdouble = "+resdoubleg);

        int resinth = (int)((3 * a - 2 * b) % (2 * a - c));
        double resdoubleh = ((3 * a - 2 * b) % (2 * a - c));
        System.out.println("(3 * a - 2 * b) % (2 * a - c) = "+((3 * a - 2 * b) % (2 * a - c))+ " resint = "+resinth+" resdouble = "+resdoubleh);

        int resinti = (int)((a - 3 * b) % (c + 2 * a) / (a - c));
        double resdoublei = ((a - 3 * b) % (c + 2 * a) / (a - c));
        System.out.println("(a - 3 * b) % (c + 2 * a) / (a - c) = "+((a - 3 * b) % (c + 2 * a) / (a - c))+ " resint = "+resinti+" resdouble = "+resdoublei);

        int resintj = (int)(a - b - c * 2);
        double resdoublej = (a - b - c * 2);
        System.out.println("a - b - c * 2 = "+(a - b - c * 2)+ " resint = "+resintj+" resdouble = "+resdoublej);

    }
}
