int fact(int n)
{
    int result = 1;
    int i = n;

    while (i > 0) {
       result *= i;
       i -= 1;
    }

    return result;
}

// SSA

int fact(int n0)
{
    int result0 = 1;
    int i0 = n0;
    int i1, i2, result1, result2, result3;

    while (i2 = phi(i0, i1), result2 = phi(result0, result1), i2 > 0) {
       result1 = result2 * i2;
       i1 = i2 - 1;
    }

    result3 = phi(result0, result2);
    return result3;
}