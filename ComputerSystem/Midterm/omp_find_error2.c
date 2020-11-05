#include <math.h>
#include <omp.h>
#include <stdio.h>
#include <stdlib.h>

void example(int n, int *a, int *b, int *y) {
    int i;
    #pragma omp parallel
    {
        #pragma omp for
        for (i=0; i < n-1; i++)
            b[i] = (a[i] + a[i+1]);
        #pragma omp single
        for (i=0; i < n-1; i++)
            y[i] = y[i+1] + b[i];
    }
}

int main(){
    int* a, *b, *y;
    int n= 5;
    a= malloc(sizeof(int) * 5);
    b= malloc(sizeof(int) * 5);
    y= malloc(sizeof(int) * 5);
    for (int i= 0; i < 5; i++){
        a[i]= rand() % 10;
        b[i]= 0;
        y[i]= 0;
    }

    example(n, a, b, y);
    printf("a: ");
    for (int i= 0; i < 5; i++){
        printf("%d ", a[i]);
    }
    printf("\nb: ");
    for (int i= 0; i < 5; i++){
        printf("%d ", b[i]);
    }
    printf("\ny: ");
    for (int i= 0; i < 5; i++){
        printf("%d ", y[i]);
    }
    printf("\n");
}
