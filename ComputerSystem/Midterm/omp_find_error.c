#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

const int MAX = 1000;

int main(int argc, char const *argv[]){
    printf("Bruh\n");
    int n = atoi(argv[1]);
    int A[MAX], B[MAX], C[MAX];
    for (int i = 0; i < n; i++){
        B[i] = i%MAX;
        C[i] = (i+1)%MAX;
    }
    for (int i = 0; i < n; i++){
        A[i] = B[i] * C[i];
        printf("%d\n", A[i]);
    }
    return 0;
}
