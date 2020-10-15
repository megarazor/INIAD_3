#include <stdio.h>
#include <omp.h>

void work1(){}
void work2(){}
void single_example(){
    int thread_n=  omp_get_max_threads();
    printf("No. of threads: %d\n", thread_n);
    #pragma omp parallel
    {
        #pragma omp master
        {
            printf("Thread %d: ", omp_get_thread_num());
            printf("Beginning work1\n");
        }
        work1();
        #pragma omp master
        {
            printf("Thread %d: ", omp_get_thread_num());
            printf("Finishing work1\n");
        }
        #pragma omp master
        {
            printf("Thread %d: ", omp_get_thread_num());
            printf("Finished work1 and beginning work2\n");
        }
        work2();
    }
}

int main(){
    single_example();
}
