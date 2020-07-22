// Original
double quad_eq(double a, double b, double c)
{
    double d = b * b - 4 * a * c;
    return (-b + sqrt(d)) / (2 * a);
}

// K-norm

double quad_eq(double a, double b, double c)
{
    double b_squared = b * b;
    double ac = a * c;
    double four_ac = 4 * ac;
    double d = b_squared * four_ac;
    double two_a = 2 * a;
    double sqrt_d = sqrt(d);
    double b_minus = -1 * b;
    double b_minus_plus_sqrt_d = b_minus + sqrt_d;
    double res= b_minus_plus_sqrt_d / two_a;
    return res;
}