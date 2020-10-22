#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <mpi.h>

int main (int argc, char** argv){
    const int server_rank= 0;
    MPI_Status status;
    int num_procs;
    int source, destination, my_rank, mpi_error_code, tag= 0, my_vote, winner= 0;
    long powered_rank= 1, sum;

    mpi_error_code= MPI_Init(&argc, &argv);
    mpi_error_code= MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);
    mpi_error_code= MPI_Comm_size(MPI_COMM_WORLD, &num_procs);

    if (num_procs > 1){
        if (my_rank != server_rank){
            srand(time(NULL) + my_rank);
            my_vote= rand() % (num_procs - 1) + 1;
            destination= server_rank;
            mpi_error_code= MPI_Send(&my_vote, 1, MPI_INT, destination, tag, MPI_COMM_WORLD);
        }
        else {
            int *results= malloc(sizeof(int) * num_procs);
            for (int i= 0; i < num_procs; i++){
                results[i]= 0;
            }

            for (source= 0; source < num_procs; source++){
                if (source != server_rank){
                    int this_vote= 0;
                    mpi_error_code= MPI_Recv(&this_vote, 1, MPI_INT, source, tag, MPI_COMM_WORLD, &status);
                    results[this_vote]+= 1;
                }
            }

            // for (source= 0; source < num_procs; source++){
            //     printf("#%d: %d votes\n", source, results[source]);
            // }

            for (source= 0; source < num_procs; source++){
                if (source != server_rank)
                {
                    if (results[source] >= results[winner]){
                        winner= source;
                    }
                }
            }   
        }
        mpi_error_code= MPI_Bcast(&winner, 1, MPI_INT, server_rank, MPI_COMM_WORLD);
        printf("Winner: #%d\n", winner);
    }
    else{
        printf("Must be at least 2 processes to vote.\n");
    }
    mpi_error_code= MPI_Finalize();
}
