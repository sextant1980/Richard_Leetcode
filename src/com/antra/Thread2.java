package com.antra;

public class Thread2 extends Thread{

    Calculate c;

    Thread2(Calculate c){
        this.c = c;
    }

    @Override
    public void run() {
        c.printTable(10);
    }
}
