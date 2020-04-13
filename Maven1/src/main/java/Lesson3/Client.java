package Lesson3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws InterruptedException, IOException {

        Socket sock = new Socket("127.0.0.1", 8189);
        ObjectOutputStream serializer = new ObjectOutputStream(sock.getOutputStream());
        Cat cat = new Cat("Vasiliy", 4);
        serializer.writeObject(cat);
        serializer.flush();
        System.out.println("На сервер отправлены данные:");
        cat.info();
        sock.close();
    }
}
