package com.antra;

public class Calculate {

    public void printTable(int n){

        synchronized(this) {
            for (int i = 0; i < 6; i++) {
                System.out.println(n + "*" + i + "=" + i * n);
            }
        }
    }


}
