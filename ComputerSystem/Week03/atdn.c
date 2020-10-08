#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#include <time.h>

int main(int argc, char *argv[]){
    int number_of_threads, this_thread, i;
    number_of_threads= omp_get_max_threads();

    double a[5];
    for (int i= 0; i< 5; i ++){
        a[i] = 0;
    }
    double b[5];

    # pragma omp parallel for
    for (i= 1; i < 5; i++){
        b[i]= (a[i] + a[i - 1]) / 2.0;
    }

}
