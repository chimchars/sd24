package client;

import server.Person;

public class ClientThread extends Thread {

    public ClientThread() {
            Person persona = new Person();
    }

    public void run() {

        TCPClient cliente = new TCPClient();
        cliente.enviaClientes(2);

    }



}
