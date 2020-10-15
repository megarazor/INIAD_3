#include <math.h>
#include <omp.h>
#include <stdio.h>
#include <stdlib.h>

void nowait_example(int n, int m, float *a, float *b, float *y){
    int i;
    #pragma omp parallel
    {
        #pragma omp for 
        for (i= 1; i < n; i++)
            b[i]= (a[i] + a[i - 1]) / 2.0;
        #pragma omp for nowait
        for (i= 1; i < m; i++)
            y[i]= sqrt(b[i - 1]);
    }
}

int main(){
    float* a, *b, *y;
    int n= 5, m= 5;
    a= malloc(sizeof(float) * 5);
    b= malloc(sizeof(float) * 5);
    y= malloc(sizeof(float) * 5);
    for (int i= 0; i < 5; i++){
        a[i]= rand() % 10;
        b[i]= 0;
        y[i]= 0;
    }

    nowait_example(n, m, a, b, y);
    printf("a: ");
    for (int i= 0; i < 5; i++){
        printf("%f ", a[i]);
    }
    printf("\nb: ");
    for (int i= 0; i < 5; i++){
        printf("%f ", b[i]);
    }
    printf("\ny: ");
    for (int i= 0; i < 5; i++){
        printf("%f ", y[i]);
    }
    printf("\n");
}
