package DesignPatternPrac;

public class MySingletonLazy2Double {
    private static volatile MySingletonLazy2Double mySingletonLazy2 = null;
    private MySingletonLazy2Double() {};

    public static MySingletonLazy2Double getMySingletonLazy2() {
        if(mySingletonLazy2 == null) {
            synchronized (MySingletonLazy2Double.class) {
                if(mySingletonLazy2 == null) {
                    mySingletonLazy2 = new MySingletonLazy2Double();
                }
            }
        }
        return mySingletonLazy2;
    }
}
