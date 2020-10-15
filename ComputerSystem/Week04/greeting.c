#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <mpi.h>

int main (int argc, char** argv){
    const int maximum_message_length= 100;
    const int server_rank= 0;
    char message[maximum_message_length + 1];
    MPI_Status status;
    int my_rank;
    int num_procs;
    int source;
    int destination;
    int tag= 0;
    int mpi_error_code;

    // Start the MPI system
    mpi_error_code= MPI_Init(&argc, &argv);

    // Get this process's rank, and the number of processes
    mpi_error_code= MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);
    mpi_error_code= MPI_Comm_size(MPI_COMM_WORLD, &num_procs);

    // If I'm not the server process:
    // 1. Create a greeting string
    // 2. Send it to the server process
    if (my_rank != server_rank){
        sprintf(message, "Greeting from process #%d!", my_rank);
        destination= server_rank;
        mpi_error_code= MPI_Send(message, strlen(message) + 1, MPI_CHAR, destination, tag, MPI_COMM_WORLD);
    }

    // If I'm the server process:
    // For each client process:
    // 1. Receive its greeting string
    // 2. Print its greeting string
    else {
        for (source= 0; source < num_procs; source++){
            if (source != server_rank){
                mpi_error_code= MPI_Recv(message, maximum_message_length + 1, MPI_CHAR, source, tag, MPI_COMM_WORLD, &status);
                fprintf(stderr, "%s\n", message);
            }
        }
    }

    // Shutdown the MPI system
    mpi_error_code= MPI_Finalize();
}
