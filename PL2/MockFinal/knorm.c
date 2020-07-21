// Original
int polynomial(int a, int b, int c, int x)
{
    return a * a * x + b * x + c;
}

// K-normalized
int polynomial(int a, int b, int c, int x)
{
    int a_squared= a * a;
    int temp1= a_squared * x;
    int temp2= b * x;
    int temp3= temp1 + temp2;
    int result= temp3 + c;
    return result;
}
