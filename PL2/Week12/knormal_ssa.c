#include <stdio.h>

// Original
int foo(int n) {
    int sum = 0;
    while(n > 0) {
        if ((n % 2) == 0) {
            sum += n * n;
        }
        else {
            sum -= n * n;
        }
        n --;
    }
    return sum;
}

// K-normalize
int foo_knorm(int n) {
    int sum = 0;
    while(n > 0) {
        int tmp1 = n % 2;
        int tmp2 = n * n;
        if (tmp1 == 0) {
            sum = sum + tmp2;
        }
        else {
            sum = sum - tmp2;
        }
        n = n - 1;
    }
    return sum;
}

// Phi dummy function
int phi(int a, int b) {
    return b;
}

// SSA form
int foo_ssa(int n0) {
    int sum0 = 0;
    int sum1, sum2, sum3, sum4, n1, n2;

    while(n2 = phi(n0, n1), sum4 = phi(sum0, sum3), n2 > 0) {
        int tmp1 = n2 % 2;
        int tmp2 = n2 * n2;
        if (tmp1 == 0) {
            sum1 = sum4 + tmp2;
        }
        else {
            sum2 = sum4 - tmp2;
        }
        sum3 = phi(sum1, sum2);
        n1 = n2 - 1;
    }
    return phi(sum0, sum3);
}

int main(){
    printf("%d\n", foo(5));
    printf("%d\n", foo_knorm(5));
    printf("%d\n", foo_ssa(5));
    return 0;
}