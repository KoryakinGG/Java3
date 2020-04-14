package Lesson4;

public class ObjectsABC {

    private final Object obj = new Object();
    private volatile char litera = 'A';

    public void printA() {
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (litera != 'A') obj.wait();
                    Thread.sleep(300);
                    System.out.print("A");
                    litera = 'B';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (litera != 'B') obj.wait();
                    Thread.sleep(300);
                    System.out.print("B");
                    litera = 'C';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (litera != 'C') obj.wait();
                    Thread.sleep(300);
                    System.out.print("C");
                    litera = 'A';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
