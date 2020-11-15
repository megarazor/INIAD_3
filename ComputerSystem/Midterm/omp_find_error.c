#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

const int MAX = 10;

int main(int argc, char const *argv[]){
    int n = atoi(argv[1]);
    int A[MAX], B[MAX], C[MAX];
    for (int i = 0; i < n; i++){
        B[i] = (i+1)%MAX;
        C[i] = (i+1)%MAX;
    }
    // Begin Section A
    #pragma omp parallel for num_threads(2)
    for (int i = 0; i < n; i++){
        A[i] = B[i] * C[i];
        printf("%d\n", A[i]);
    }
    // End Section A
    return 0;
}
