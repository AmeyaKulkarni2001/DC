import java.util.Scanner;

/**
 * bully
 */
public class bully {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int length = s.nextInt();
        int[] nodes = new int[length];
        int[] state = new int[length];
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < length; i++) {
            nodes[i] = s.nextInt();
        }
        System.out.println("Enter the state of the nodes:");

        for (int i = 0; i < length; i++) {
            state[i] = s.nextInt();
        }

        // System.out.println(Arrays.toString(nodes));
        // System.out.println(Arrays.toString(state));

        // System.out.println("Which nodes do you want to fail");
        // int fail = s.nextInt();

        System.out.println("Enter the discovering node");
        int start = s.nextInt();

        int max = 0,count = 0;

        for(int i = 0; i < nodes.length; i++){
            if(nodes[start] < nodes[i]){
                count++;
            }
        }

        while(count > 0){
            for(int i = 0; i < nodes.length; i++){
                if(state[start] == 1 && nodes[start] < nodes[i]){
                    System.out.print(nodes[start]+" Sends message to ");
                    System.out.print(nodes[i]);
                    System.out.println("");
                }
            }
            for(int i = 0; i < nodes.length; i++){
                if(state[start] == 1 && state[i] == 1 && nodes[start] < nodes[i]){
                    System.out.print(nodes[i]+" Replies with OK to ");
                    System.out.println(nodes[start]);

                    max= Math.max(max, nodes[i]);
                }
            }
            count--;
            start++;
        }
        System.out.println(max + " Is the new Cordinator");
       s.close();
    }
}
