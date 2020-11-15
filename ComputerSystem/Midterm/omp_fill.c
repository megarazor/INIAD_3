#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

const int MAX = 1000;

int main(int argc, char const *argv[]){
    #pragma omp parallel num_threads(5)
    {
        printf("Hello\n");
    }
    return 0;

}
