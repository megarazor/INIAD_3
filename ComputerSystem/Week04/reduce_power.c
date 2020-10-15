#include <stdlib.h>
#include <stdio.h>
#include <mpi.h>

int main (int argc, char** argv){
    const int server= 0;
    int num_procs;
    int source, destination, my_rank, mpi_error_code;
    long powered_rank= 1, sum;

    mpi_error_code= MPI_Init(&argc, &argv);
    mpi_error_code= MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);
    mpi_error_code= MPI_Comm_size(MPI_COMM_WORLD, &num_procs);

    for (int i= 0; i < my_rank; i++){
        powered_rank*= my_rank;
    }    
    if (my_rank == server){
        powered_rank= 0;
    }
    // printf("My rank: %d\nPowered rank: %ld\n", my_rank, powered_rank);

    mpi_error_code= MPI_Reduce(&powered_rank, &sum, 1, MPI_LONG, MPI_SUM, server, MPI_COMM_WORLD);

    double average= (sum * 1.0) / (num_procs * 1.0);
    if (my_rank == server){
        printf("Sum: %ld\nAverage: %f\n", sum, average);
    }

    mpi_error_code= MPI_Finalize();
}
