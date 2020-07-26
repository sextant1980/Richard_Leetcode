package com.spring.concept;

public class myMain {
    public static void main(String[] args) {
        myInterface myObj = new mySubclass2();
        TopClass topObj = new TopClass(myObj);
        topObj.doTheThing();
    }
}
