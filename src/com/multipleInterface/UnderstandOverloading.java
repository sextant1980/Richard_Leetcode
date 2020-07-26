package com.multipleInterface;

import java.io.PrintStream;

public class UnderstandOverloading {
    public void goToTown(String string) {
        System.out.println(string);
    }

    public void goToTown(int x) {
        System.out.println(x);
    }

    public void tryout() {
        goToTown(10);
    }
    public static void main(String[] args) {
        UnderstandOverloading undy = new UnderstandOverloading();
        undy.goToTown(10);
        undy.goToTown("haha");

//        System
    }


}
