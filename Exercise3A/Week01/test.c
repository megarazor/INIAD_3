#include <stdio.h>
static int global_static_variable = 10;

int function(int* p) {
    *p= 10;
}

int main(int argc, char const* argv[])
{
    int a= 5;
    function(&a);
    printf("%d\n", a);
    return 0;
}
