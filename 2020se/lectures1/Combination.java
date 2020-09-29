public class Combination {
    public static int combination(int n, int r) {
        if (n == r){
            return 1;
        }
        int numer= 1;
        int denom= 1;
        for (int i = 1; i <= n; i++) {
            numer= numer * i;
            if (i <= n - r){
                denom= denom * i;
            }
            if (i <= r){
                denom= denom * i;
            }
        }
        // System.out.printf("%d, %d\n", numer, denom);
        return numer / denom;
    }

    public static void main(String[] args) {
        int n = 10;
        int r = 9;
        int c = combination(n, r);
        System.out.printf("C(%d, %d) = %d\n", n, r, c);
    }
}