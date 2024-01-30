package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    //servidor regresa nombre correspondiente a clave
    public static void main(String args[]) {
        try {
            int serverPort = 49152;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while (true) {
                System.out.println("Waiting for messages...");
                Socket clientSocket = listenSocket.accept();  // Listens for a connection to be made to this socket and accepts it. The method blocks until a connection is made.
                Connection c = new Connection(clientSocket);
                c.start();
            }
        } catch (IOException e) {
            System.out.println("Listen :" + e.getMessage());
        }
    }

}

class Connection extends Thread {
    private DataInputStream in;
    private DataOutputStream out;
    private Socket clientSocket;

    public Connection(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            //while solivitud != -1
            int key = Integer.parseInt(in.readUTF()); // recibo solicitud
            long startTime = System.nanoTime();

            while(key!=-1){

                System.out.println("Message received from: " + clientSocket.getRemoteSocketAddress());
                AddressBook addressBook = new AddressBook();
                String nombre = addressBook.getRecord(key).getName();
                //out.writeUTF(data);                // envio respuesta
                out.writeUTF(nombre);
            }
            long estimatedTime = System.nanoTime() - startTime;
            String tiempoRespuestas = String.valueOf(estimatedTime);
            System.out.println("Tiempo transcurrido:" + tiempoRespuestas);
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
