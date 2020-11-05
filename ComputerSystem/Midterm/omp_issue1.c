#include <math.h>
#include <omp.h>
#include <stdio.h>
#include <stdlib.h>

int main(){
    int *X, *Y, *Z;
    int n= 20;
    X= malloc(sizeof(int) * n);
    Y= malloc(sizeof(int) * n);
    Z= malloc(sizeof(int) * n);
    for (int i= 0; i < n; i++){
        X[i]= 0;
        Y[i]= rand() % n;
        Z[i]= rand() % n;
    }

    #pragma omp parallel for
    // for (int i = 0; i < n; i++){
    for (int i = 0; i < n - 1; i++){
        // X[i] = Y[Z[i]];
        X[i] = Y[i+1] + Y[Z[i]];
    }
    
    for (int i = 0; i < n; i++){
        printf("%d ", X[i]);
    }
    printf("\n");
    for (int i = 0; i < n; i++){
        printf("%d ", Y[i]);
    }
    printf("\n");
    for (int i = 0; i < n; i++){
        printf("%d ", Z[i]);
    }
    printf("\n");
}
