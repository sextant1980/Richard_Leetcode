package com.antra;

public class ThreadEX {

    public static void main(String[] args) {

        Calculate c = new Calculate();

        Thread1 mt1 = new Thread1(c);
        Thread2 mt2 = new Thread2(c);

        mt1.start();
        mt2.start();
    }
}
