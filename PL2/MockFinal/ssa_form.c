// Original
int sumrange(int n, int m)
{
    int sum = 0;

    while (n <= m) {
        sum += n;
        n++;
    }

    return sum;
}

// Dummy phi function
int phi(int a, int b){
    return b;
}

// SSA form
int sumrange(int n0, int m)
{
    int sum0= 0, sum1= 0, sum2, sum3;
    int n1= n0, n2;
    while (n2= phi(n0, n1), sum2= phi(sum0, sum1), n2 <= m) {
        sum3 = sum2 + n2;
        n1= n2 + 1;
    }
    int result= phi(sum0, sum3);
    return result;
}
