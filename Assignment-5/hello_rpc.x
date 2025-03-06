/* hello_rpc.x - RPC Definition */
program HELLO_PROG {
    version HELLO_VERS {
        void HELLO_FUNC(void) = 1;
    } = 1;
} = 0x20000001;
