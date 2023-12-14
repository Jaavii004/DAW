public class fibonacci{
    public static int fibonaccii(int N) {
        int res;
        if (N == 0) {
            res = 0;
        } else if (N == 1) {
            res=1;
        } else {
            res = fibonaccii(N - 1) + fibonaccii(N - 2);
        }
        return res;
    }

    public static void main (String[] args) {
        System.out.println(fibonaccii(Integer.valueOf(args[0])));
    }
}