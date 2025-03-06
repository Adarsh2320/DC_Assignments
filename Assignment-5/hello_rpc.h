#ifndef _HELLO_RPC_H_RPCGEN
#define _HELLO_RPC_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


#define HELLO_PROG 0x20000001
#define HELLO_VERS 1

#if defined(__STDC__) || defined(__cplusplus)
#define HELLO_FUNC 1
extern  void * hello_func_1(void *, CLIENT *);
extern  void * hello_func_1_svc(void *, struct svc_req *);
extern int hello_prog_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define HELLO_FUNC 1
extern  void * hello_func_1();
extern  void * hello_func_1_svc();
extern int hello_prog_1_freeresult ();
#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif 
