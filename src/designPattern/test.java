package designPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(50);
        for(int i = 0; i < 60; i++){
            ex.submit(() -> System.out.println(MySingletonC.getMySingletonC()));
        }
        ex.shutdown();
    }

}
