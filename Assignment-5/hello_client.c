#include <stdio.h>
#include <stdlib.h>
#include "hello_rpc.h"

int main(int argc, char *argv[]) {
    CLIENT *clnt;

    if (argc != 2) {
        fprintf(stderr, "Usage: %s <server-hostname>\n", argv[0]);
        exit(1);
    }

    /* Create RPC client */
    clnt = clnt_create(argv[1], HELLO_PROG, HELLO_VERS, "tcp");
    if (clnt == NULL) {
        clnt_pcreateerror(argv[1]);
        exit(1);
    }

    /* Call the remote procedure */
    hello_func_1(NULL, clnt);
    printf("RPC Call Sent!\n");

    /* Destroy client */
    clnt_destroy(clnt);
    return 0;
}
