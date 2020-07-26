package designPattern;

public class MySingletonC {
    private static volatile MySingletonC mySingletonC = null;

    private MySingletonC() {
    }

    public static MySingletonC getMySingletonC(){
        if(mySingletonC == null){
            synchronized(MySingletonC.class) {
                if(mySingletonC == null){
                    mySingletonC = new MySingletonC();
                }
            }
        }
        return mySingletonC;
    }
}
