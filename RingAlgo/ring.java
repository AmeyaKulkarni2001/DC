import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class CircularList {
    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

    }

    public Node head = null;
    public Node tail = null;

    public void add(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            System.out.println("Nodes of the circular linked list: ");
            do {
                System.out.print(" " + current.val);
                current = current.next;
            } while (current != head);
            System.out.println();
        }
    }
    // public void display(int value){
    // Queue<Integer> qu = new LinkedList<Integer>();
    // Node curr = head;
    // int max = 0;
    // while(curr.val != value){
    // curr = curr.next;
    // }
    // // System.out.println(curr.val + " is sending message");
    // qu.add(curr.val);
    // System.out.println(qu);
    // curr = curr.next;
    // while(curr.val != value){
    // qu.add(curr.val);
    // System.out.println(qu);
    // curr = curr.next;
    // // System.out.println(curr.val + " is sending message");
    // max = Math.max(max, curr.val);
    // }

    // System.out.println(qu);
    // System.out.println("Leader is "+ max);

    // }
    public void display(int value) {
        Queue<Integer> qu = new LinkedList<Integer>();
        Node curr = head;
        Node temp = head;
        while (curr.val != value) {
            curr = curr.next;
        }
        qu.add(curr.val);
        System.out.println(curr.val + "Sends message");
        System.out.println(qu);
        curr = curr.next;
        while (curr.val != value) {

            if (curr.val > value) {
                qu.remove();
                qu.add(curr.val);
                System.out.println(curr.val + "Sends message");

                System.out.println(qu);
                value = curr.val;
                curr = curr.next;
            } else {
                System.out.println(curr.val);
                curr = curr.next;
            }
        }
        while (temp.val != value) {
            System.out.println(temp.val + " Sends message that leader is " + value);
            temp = temp.next;
        }

        System.out.println("Leader is " + value);
    }

    public void delete(int value) {
        Node curr = head;
        while (curr.val != value - 1) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
    }
}

public class ring {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        CircularList nodes = new CircularList();
        int option = 0;
        int start = 0;
        int down = 0;
        do {

            System.out.println("Enter the next node");
            start = s.nextInt();
            nodes.add(start);
            System.out.println("Do you want to add a node 0/1");
            option = s.nextInt();

        } while (option == 1);
        nodes.display();

        System.out.println("Enter the val of the node which will go down");
        down = s.nextInt();
        nodes.delete(down);
        nodes.display();
        System.out.println("Which node will circulate the message");
        nodes.display(s.nextInt());

        s.close();
    }
}
