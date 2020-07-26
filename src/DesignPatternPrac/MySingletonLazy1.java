package DesignPatternPrac;

public class MySingletonLazy1 {
    private static MySingletonLazy1 mySingletonLazy1 = null;

    private MySingletonLazy1() {

    }

    public synchronized static MySingletonLazy1 getMySingletonLazy1() {
        if(mySingletonLazy1 == null) {
            mySingletonLazy1 = new MySingletonLazy1();
        }
        return mySingletonLazy1;
    }
}
