// Original
int fact(int n)
{
    int tmp1, tmp2, tmp3;

    tmp1 = n - 1;
    tmp2 = fact(tmp1);
    tmp3 = n * tmp2;
    return tmp3;
}

// Allocation, 64x
int fact(int %rdi)
{
    %rax = %rdi - 1;
    %rsi = fact(%rax);
    %rax = %rdi * %rsi;
    return %rax;
}

// Answer?

int fact(int %rdi)
{
    Save(x, %rdi);
    %rdi = %rdi - 1;
    %rax = fact(%rdi);
    Restore(x, %rsi);
    %rax = %rsi * %rax;
    return %rax;
}