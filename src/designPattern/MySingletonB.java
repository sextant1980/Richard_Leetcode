package designPattern;

public class MySingletonB {
    private static MySingletonB mySingletonB = null;
    private MySingletonB(){

    }
    public static MySingletonB getMySingletonB(){
        if(mySingletonB == null) {
            mySingletonB = new MySingletonB();
        }
        return mySingletonB;
    }
}
