#include <stdio.h>
#include <stdlib.h>

int main(){
    const int N= 5;
    int *a, *b, *c;
    a= malloc(sizeof(int) * N);
    b= malloc(sizeof(int) * N);
    c= malloc(sizeof(int) * N);

    for (int i= 0; i < N; i++){
        a[i]= rand() % 10;
        // b[i]= 0;
        c[i]= 0;
    }
    #pragma acc kernels async(3)
    for (int i = 0; i < N; i++){
        b[i] = a[i]-1;
        // printf("A");
    }
    // printf("\n");
    #pragma acc kernels async(2)
    for (int i = 0; i < N; i++){
        c[i] = N*b[i];
        // printf("B");
    }
    // printf("\n");
    #pragma acc kernels wait(3)

    for (int i= 0; i < N; i++){
        printf("%d ", a[i]);
    }
    printf("\n");
    for (int i= 0; i < N; i++){
        printf("%d ", b[i]);
    }
    printf("\n");
    for (int i= 0; i < N; i++){
        printf("%d ", c[i]);
    }
    printf("\n");
        
    free(a);
    free(b);
    free(c);
}

