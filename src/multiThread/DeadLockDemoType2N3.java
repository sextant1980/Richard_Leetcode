package multiThread;

public class DeadLockDemoType2N3 {
    public static void main(String[] args) {
        DeadlockDepend3 depend3 = new DeadlockDepend3();
        Object depend4 = new Object();
//        DeadlockDepend2 depend2 = new DeadlockDepend2();
//        MyThread1 myThread1 = new MyThread1(depend1, depend2);
//        myThread1.start();

        Runnable r3 = () -> {
            depend3.method3(depend4);
        };

        Runnable r4 = () -> {
            synchronized (depend4){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                depend3.printSomething3();
            }
        };

        Thread mt3 = new Thread(r3);
        Thread mt4 = new Thread(r4);
        mt3.start();
        mt4.start();
    }
}

class DeadlockDepend3 {
    public synchronized void method3(Object obj){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj) {
            System.out.println("here in depend3.method1");
        }
    }

    public synchronized void printSomething3(){
        System.out.println("here in depend3.printSomething3");
    }
}
