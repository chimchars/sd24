package client;

import server.AddressBook;

import java.net.*;
import java.io.*;


public class TCPClient {
    // k clientes
    // cada cliente envia n solicitudes a AddressBook
    // cliente envia id a servidor y recibe nombre
    // params: k, n (qty clientes, qty solicitudes)
    // objetivo: ver cuantas conexiones puede aguantar & cuanto tarda
    // con la q responde: variacion std
    private double stDev() {
        double resp = 0;
        return resp;
    }

    public static void main(String[] args) {
        Socket s = null;
        try {
            int serverPort = 49152;

            s = new Socket("localhost", serverPort);
            //s = new Socket("127.0.0.1", serverPort);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            AddressBook addressBook = new AddressBook();
        

            out.writeUTF("Hello");

            String data = in.readUTF();
            System.out.println("Received: " + data);

        } catch (UnknownHostException e) {
            System.out.println("Sock:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        } finally {
            if (s != null) try {
                s.close();
            } catch (IOException e) {
                System.out.println("close:" + e.getMessage());
            }
        }
    }

}
