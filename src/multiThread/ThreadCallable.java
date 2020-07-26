package multiThread;

import java.util.concurrent.*;

public class ThreadCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {return "abc";};

        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 20; i++){
            Future<String> future = es.submit(callable);
            System.out.println(i + ": " + future.get());
        }
        es.shutdown();
    }
}
