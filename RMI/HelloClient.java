import java.rmi.*;
//import java.io.*;

public class HelloClient {
    public static void main(String[] argv) {
        try {
            HelloInterface hello = (HelloInterface) Naming.lookup("//172.16.188.63/Hello"); //serveripaddr
            System.out.println(hello.say());
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }
    }
}
