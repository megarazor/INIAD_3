#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

const int MAX= 10;

void example(int n, float *a, float *b, float *y) {
    int i;
    #pragma omp parallel for
    for (i=0; i < n-1; i++) 
        b[i] = (a[i] + a[i+1]);
    #pragma omp single
    for (i=0; i < n-1; i++) 
        y[i] = y[i+1] + b[i];
}

int main(){
    float a[MAX], b[MAX], y[MAX];
    for (int i= 0; i < MAX; i++){
        a[i]= rand() % MAX;
        b[i]= 0;
        y[i]= 0;
    }

    example(MAX, a, b, y);
    for (int i= 0; i < MAX; i++){
        printf("%f ", b[i]);
    }
    printf("\n");
    for (int i= 0; i < MAX; i++){
        printf("%f ", y[i]);
    }
    printf("\n");
}
