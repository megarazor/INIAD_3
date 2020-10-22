#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

int main(){
    const int N= 10;
    float *A, *B, *C;
    A= malloc(sizeof(float) * N);
    B= malloc(sizeof(float) * N);
    C= malloc(sizeof(float) * N);

    for (int i= 0; i < N; i++){
        A[i]= 0;
        B[i]= i * 1.2;
        C[i]= i * 2.1;
    }

    #pragma omp parallel for ordered
    for (int i= 0; i < N; i++){
        A[i]= B[i] * C[i];
        #pragma omp ordered
        printf("%f = %f x %f\n", A[i], B[i], C[i]);
    }
    
    free(A);
    free(B);
    free(C);
}
