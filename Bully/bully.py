process_list = []
no_process = int(input("Enter the number of process:: "))
for i in range(1,no_process+1):
        process_list.append(i)
List = [1] * no_process
global List_count
List_count = [1]* no_process
curr_coor = max(process_list)
print(List_count)
print(process_list)
print(List)

def display():
    print("\n  Process-->     ", process_list)
    print("\n Alive Process-->", List)
    print("\n Process Count-->", List_count)
    print("\ncoordinator is:: ", curr_coor)
    

def Bully():
    crash = int(input("Enter a process to crash: "))
    List[crash-1] = 0
    cord = curr_coor
    starter = int(input("Enter a process to start the election: "))
    Flag = 0
    if(crash == cord):
        for i in range(starter, no_process+1):
            print('THis is I', i)
            for j in range(i+1,no_process+1):
                print('THis is J', j)
                print(f"\n message is sent from {i}  to {j} ")
                if (List[j-1] == 1):
                    print(f"\n Response is sent from {j}  to {i} ")
                    List_count[i-1] = List_count[i-1]+1
                else:
                    List_count[i-1] = List_count[i-1]-1
        cord = List_count.index(min(List_count))+1
        return cord
    else:
        return cord
    
display()
print("\n1.BULLY ALGORITHM\n2.EXIT")
choice = int(input("Enter your choice::"))
if (choice ==1):
    new_cords = Bully()
    print("The new Coordinator is", new_cords)

else:
    pass   
