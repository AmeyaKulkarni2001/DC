//import java.io.*;
import java.rmi.*;

public class HelloServer {
    public static void main(String[] argv) {
        try {
            System.setProperty("java.rmi.server.hostname", "172.16.188.63"); //ipaddr of server
            Hello robj = new Hello("Hello, World!");
            Naming.rebind("Hello", robj);
            System.out.println("Hello Server is ready.");
        } catch (Exception e) {
            System.out.println("Hello Server failed:" + e);
        }
    }
}
