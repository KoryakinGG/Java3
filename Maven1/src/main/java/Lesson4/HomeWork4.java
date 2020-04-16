package Lesson4;

/*
 *Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
 * */
public class HomeWork4 {

    public static void main(String[] args) {

            ObjectsABC thread = new ObjectsABC();

            new Thread(() -> thread.printA()).start();
            new Thread(() -> thread.printB()).start();
            new Thread(() -> thread.printC()).start();

    }
}