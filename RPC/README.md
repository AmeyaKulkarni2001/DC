## How to run

```
rpcgen square.x
# Compiling the client
cc -c r_client.c
cc -c square_clnt.c
cc -c square_xdr.c
cc -o client  r_client.o square_clnt.o square_xdr.c

#Compiling the server
cc -c r_server.c
cc -c square_svc.c
cc -c square_xdr.c
cc -o server  r_server.o square_svc.o square_xdr.c

# Running server
./server &

# Running client
Client 127.0.0.1 4
```


