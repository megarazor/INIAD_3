int foo(int a, int b){
    int a2, b2, c2, c;

    a2 = a * a;
    b2 = b * b;
    c2 = a2 + b2;
    c= sqrt(c2);
    return c;
}

// Register allocation
/*
a:  %edi
b:  %esi
a2: %eax
b2: %edi 
c2: %esi
c:  %eax // Return value
*/
// Answer:
/*
int foo(int %edi, int %esi){
    %eax = %edi * %edi;
    %edi = %esi * %esi;
    %esi = %eax + %edi;
    %eax = sqrt(%eax);
    return %eax;
} */