#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <mpi.h>

int main(int argc, char *argv[]){
    const int server = 0;
    int vote, source, winner;
    int num_procs, my_rank, mpi_error_code;
    int tag = 0;
    MPI_Status status;
    mpi_error_code = MPI_Init(&argc, &argv);
    mpi_error_code = MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);
    mpi_error_code = MPI_Comm_size(MPI_COMM_WORLD, &num_procs);

    if (num_procs > 1){
        if (my_rank != server){ 
            /* Non-server votes to one of non-server processes*/
            srand(time(0));
            vote = rand() % (num_procs - 1) + 1;
            mpi_error_code = MPI_Send(&vote, 1, MPI_INT, server, tag, MPI_COMM_WORLD);
        }
        else{ /* Server counts */
            int vote_cnt[num_procs];
            for (int i = 0; i < num_procs; i++){
                vote_cnt[i] = 0;
            }
            for (source = 1; source < num_procs; source++){
                if (source != server){
                    mpi_error_code = MPI_Recv(&vote, 1, MPI_INT, source, tag, MPI_COMM_WORLD, &status);
                    vote_cnt[vote] += 1;
                }
            }
            /* Find a winner and broadcast it */
            int max = 0;
            for (int i = 1; i < num_procs; i++){
                if (max <= vote_cnt[i]){
                    max = vote_cnt[i];
                    winner = i;
                }
            }
        }

        MPI_Bcast(&winner, 1, MPI_INT, server, MPI_COMM_WORLD);
        printf("Winner process#:%d\n", winner);
    }

    else{
        printf("No candidate (and no vote is taking place)\n");
    }

    mpi_error_code = MPI_Finalize();
    return 0;
}
