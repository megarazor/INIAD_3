#include <stdio.h>
#include <omp.h>

int main(){
    int thread_n=  omp_get_max_threads();
    printf("Threads: %d\n", thread_n);
    #pragma omp parallel
    {
        for (int j= 0; j < thread_n; j++){
            printf("Hello\n");
        }
    }
}
