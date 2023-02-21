/* This is the RPC specification file,with a .x extension */
/* The procedures declared in this file are visible/accesible to the client*/

struct square_in    /* input structure */
{
long arg1;
};
struct square_out {  /* output result structur*/
long res1;
};
program SQUARE_PROG{  /* program name*/
version SQUARE_VERS {    /* program version number */
/*the procedure name takes input struct as parameter and returns output struct*/
square_out SQUAREPROC(square_in)=1;/* assigned to 1 */  
}=1; /* version number is 1 */                                
}= 0x31230000; /* program number,user defined range by Solaris */














