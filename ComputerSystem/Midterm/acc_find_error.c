#include <stdio.h>
#include <stdlib.h>

int main(){
    const int N= 10;
    float *a, *b, *c;
    a= malloc(sizeof(float) * N);
    b= malloc(sizeof(float) * N);
    c= malloc(sizeof(float) * N);

    for (int i= 0; i < N; i++){
        a[i]= rand() % 10;
        b[i]= 0;
        c[i]= 0;
    }
    #pragma acc kernels async(3)
    for (int i = 0; i < N; i++){
        b[i] = a[i]-1;
    }
    #pragma acc kernels async(3)
    for (int i = 0; i < N; i++){
        c[i] = N*b[i];
    }
    #pragma acc kernels wait(3)

    for (int i= 0; i < N; i++){
        printf("%f %f %f\n", a[i], b[i], c[i]);
    }
        
    free(a);
    free(b);
    free(c);
}

