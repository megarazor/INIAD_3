public class Combination {
    public static int combination(int n, int r) {
        int n_= 1, r_= 1, n_r_= 1;
        for (int i= 2; i <= n; i++){
            if (i <= r){
                r_*= i;
            }
            if (i <= n - r){
                n_r_*= i;
            }
            n_*= i;
        }
        return n_ / (r_ * n_r_);
    }

    public static void main(String[] args) {
        int n = 10;
        int r = 3;
        int c = combination(n, r);
        System.out.printf("C(%d, %d) = %d\n", n, r, c);
    }
}