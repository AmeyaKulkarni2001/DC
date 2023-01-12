#include <stdio.h>

int maximum(int a,int b){
  if (a > b){
    return a;
  } else {
    return b;
  }
  return a;
}

void main(){
  //Sort the array first
  // int n;
  // printf("Enter the number of nodes");
  // scanf("%d",n);

  int nodes[] = {1,2,3,4,5,6,7};
  // int nodes[n];
  // for(int i = 0; i < n; i++){
  //   printf("enter the %d node",i);
  //   scanf("%d",nodes[i]);
  // }
  

  int start =  2;
  size_t n = sizeof(nodes)/sizeof(nodes[0]);

  int state[] = {1,1,1,1,1,1,0};
  size_t s = sizeof(state)/sizeof(state[0]);
  int max;
  int count = 0;
  for(int i = 0; i<n; i++){
    if(nodes[start] < nodes[i]){
      count++;
    }
  }
  while(count > 0){

    // sending message
    for(int i = 0; i<n; i++){count
        
      if(nodes[start] < nodes[i]){
        printf("Node %d ",nodes[start]);printf("sends message to %d \n",nodes[i]);
      }
    }
    // reply
    for(int i = 0; i < s; i++){
      // printf("%d",state[i]);
      if(state[i] == 1 && nodes[start] < nodes[i]){
        printf("Node %d",nodes[i]);printf(" replies ok \n");
        max = maximum(max, nodes[i]);
      }
    }
    count--;
    start++;
  }

 printf("%d is the new leader ",max);

}
