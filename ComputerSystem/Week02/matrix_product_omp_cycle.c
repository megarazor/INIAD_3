#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#include <time.h>

int main(int argc, char *argv[]){
    int size= 64;
    if (argc > 1){
        size= atoi(argv[1]);
    }
    int **A, **B, **C;

    // Initialize the 3 matrices
    A= malloc(sizeof(*A) * size);
    B= malloc(sizeof(*A) * size);
    C= malloc(sizeof(*A) * size);
    for (int i= 0; i < size; i++){
        A[i]= malloc(size * sizeof(int));
        B[i]= malloc(size * sizeof(int));
        C[i]= malloc(size * sizeof(int));
        for (int j= 0; j < size; j++){
            A[i][j]= rand() % 10;
            B[i][j]= rand() % 10;
            C[i][j]= 0;
        }
    }

    // Multiplication
    int number_of_threads, this_thread, i;
    number_of_threads= omp_get_max_threads();

    clock_t start, end;
    long cycles;
    start = clock();

    # pragma omp parallel for
    for (i= 0; i < size; i++){
        // this_thread= omp_get_thread_num();
        // fprintf(stderr, "Iteration %2d, thread %2d\n", i, this_thread);
        for (int j= 0; j < size; j++){
            for (int k= 0; k < size; k++){
                C[i][j]+= A[i][k] * B[k][j];
            }
        }
    }
    end = clock();
    cycles = (long) (end - start);
    // Time print
    printf("Clock cycles: %ld\n", cycles);
    
    // Result print
    // printf("A:\n");
    // for (int i= 0; i < size; i++){
    //     for (int j= 0; j < size; j++){
    //         printf("%d ", A[i][j]);
    //     }
    //     printf("\n");
    // }
    // printf("\nB:\n");
    // for (int i= 0; i < size; i++){
    //     for (int j= 0; j < size; j++){
    //         printf("%d ", B[i][j]);
    //     }
    //     printf("\n");
    // }
    // printf("\nC:\n");
    // for (int i= 0; i < size; i++){
    //     for (int j= 0; j < size; j++){
    //         printf("%d ", C[i][j]);
    //     }
    //     printf("\n");
    // }
    free(A);
    free(B);
    free(C);

}
