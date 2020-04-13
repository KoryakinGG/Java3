package Lesson3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("server is ready");
        Socket sock = serverSocket.accept();
        ObjectInputStream deserializer = new ObjectInputStream(sock.getInputStream());
        Cat cat = (Cat) deserializer.readObject();
        System.out.println("Данные прочитаны: ");
        cat.info();
        sock.close();
        serverSocket.close();
    }
}
