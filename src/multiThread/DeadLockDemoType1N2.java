package multiThread;

public class DeadLockDemoType1N2 {
    public static void main(String[] args) {
        DeadlockDepend1 depend1 = new DeadlockDepend1();
        DeadlockDepend2 depend2 = new DeadlockDepend2();
        MyThread1 myThread1 = new MyThread1(depend1, depend2);
        myThread1.start();

        Runnable r2 = () -> {depend2.method2(depend1);};
        Thread myThread2 = new Thread(r2);
        myThread2.start();
    }
}

class MyThread1 extends Thread {
    DeadlockDepend1 depend1;
    DeadlockDepend2 depend2;

    public MyThread1(DeadlockDepend1 depend1, DeadlockDepend2 depend2){
        this.depend1 = depend1;
        this.depend2 = depend2;
    }

    @Override
    public void run(){
        depend1.method1(depend2);
    }
}

class DeadlockDepend1 {
    public synchronized void method1(DeadlockDepend2 depend2){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        depend2.printSomething2();
    }

    public synchronized void printSomething1(){
        System.out.println("here in depend1.printSomething1");
    }
}

class DeadlockDepend2 {
    public synchronized void method2(DeadlockDepend1 depend1){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        depend1.printSomething1();
    }

    public synchronized void printSomething2(){
        System.out.println("here in depend2.printSomething2");
    }
}