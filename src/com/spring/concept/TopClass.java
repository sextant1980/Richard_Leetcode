package com.spring.concept;

public class TopClass {

    private myInterface myItObj;

    public TopClass(myInterface myItObj) {
        this.myItObj = myItObj;
    }

    public void doTheThing() {
        this.myItObj.doSomeThing();
    }
}
