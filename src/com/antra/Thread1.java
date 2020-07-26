package com.antra;

public class Thread1 extends Thread{

    Calculate c;

    Thread1(Calculate c){
        this.c = c;
    }

    @Override
    public void run(){
        c.printTable(2);
    }
}
