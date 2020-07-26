package designPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MySingletonA {
    private static final MySingletonA mySingletonA = new MySingletonA();

    private MySingletonA(){
//        if(mySingletonA != null){
//            throw new RuntimeException("cannot create");
//        }
    };

    public static MySingletonA getMySingletonA(){
        return mySingletonA;
    }
}

class tmp {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName("designPattern.MySingletonA");
        Constructor constructor = c.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        Object obj = constructor.newInstance(null);
        System.out.println(obj);

        Object obj2 = MySingletonA.getMySingletonA();
        System.out.println(obj2);
    }
}