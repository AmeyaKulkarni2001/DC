#include <sys/types.h>
#include <sys/time.h>
#include <time.h>
#include <errno.h>
#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <unistd.h>
#include <rpc/rpc.h>
#include <netinet/in.h>
#include "square.h"
/* This is the server code,the main() routine is inserted by RPC */
/* the procedure is  actually defined here */
square_out *
/* Struct svc_req *rqstp is a poiter to the structure passed by RPC runtime*/
/* This struct contains information about the invocation */
squareproc_1_svc(square_in *inp,struct svc_req *rqstp)
{
/* the address of variable is returned therefore it is static and not auto*/
static square_out out;
/* computation of a square of the passed number */
out.res1=inp->arg1 * inp->arg1;
/*result is returned */
return(&out);
} 

















