package multiThread;

public class DeadLockDemoType3N3 {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Runnable r1 = () -> {
            synchronized (obj1) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("here in obj1");
                }
            }
        };

        Runnable r2 = () -> {
            synchronized (obj2) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("here in obj2");
                }
            }
        };

        Thread mt1 = new Thread(r1);
        Thread mt2 = new Thread(r2);
        mt1.start();
        mt2.start();
    }
}
