package DesignPatternPrac;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MySingletonEager {
    private static final MySingletonEager mySingleton = new MySingletonEager();

    private MySingletonEager() {
//        if(mySingleton != null) {
//            throw new RuntimeException("cannot create another singleton object!");
//        }
    }

    public static MySingletonEager getMySingleton() {
        return mySingleton;
    }
}

class TryOut {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        MySingletonEager mySingletonEager = MySingletonEager.getMySingleton();
        Class myClass = Class.forName("DesignPatternPrac.MySingletonEager");
        Constructor constructor = myClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        Object newObj = constructor.newInstance(null);
        System.out.println(mySingletonEager);
        System.out.println(newObj);
    }
}
