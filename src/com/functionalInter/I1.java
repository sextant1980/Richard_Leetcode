package com.functionalInter;

@FunctionalInterface
public interface I1 {

    public void m1();
    public String toString();

    default void m2(){

    }

    public static void m3(){

    };

}
