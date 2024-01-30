package client;

public class Launcher {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ClientThread hilo = new ClientThread();
            hilo.start();
        }
    }
}
