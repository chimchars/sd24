package HW;

import java.net.*;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import HW.Person;

public class TCPClient {

    public static void main(String args[]) {

        Socket s = null;

        try {
            int serverPort = 49152;

            s = new Socket("localhost", serverPort);
            //s = new Socket("127.0.0.1", serverPort);
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

            Person me = (Person) in.readObject();
            System.out.println("Received: " + me);
            me = new Person("Santi", "Ams", 1999);
            out.writeUTF("Hello");            // UTF is a string encoding
            out.writeObject(me);





        } catch (UnknownHostException e) {
            System.out.println("Sock:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (s != null) try {
                s.close();
            } catch (IOException e) {
                System.out.println("close:" + e.getMessage());
            }
        }
    }
}