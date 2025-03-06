#include <stdio.h>
#include <stdlib.h>
#include "hello_rpc.h"

void *hello_func_1_svc(void *argp, struct svc_req *rqstp) {
    printf("Hello from the RPC Server!\n");
    static int result = 0;
    return (void *)&result;
}
