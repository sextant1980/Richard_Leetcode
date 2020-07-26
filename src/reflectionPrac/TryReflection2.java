package reflectionPrac;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TryReflection2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Vehicle vehicle = new Vehicle("dabi", "red", 3);
        Car car = new Car("xiaobi", "white", 5);

        Class vehicleClass = Class.forName("reflectionPrac.Vehicle");
        Class carClass = car.getClass();

        Method method = carClass.getMethod("getLength");
        method.invoke(car);
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> returnType = method.getReturnType();

        System.out.println(parameterTypes);
        System.out.println(returnType);

        Field[] fields = vehicleClass.getDeclaredFields();
//        for(Field f : fields) {
//            String fName = f.getName();
//            f.setAccessible(true);
//            try {
//                Field carField = carClass.getDeclaredField(fName);
//                carField.setAccessible(true);
//                carField.set(car, f.get(vehicle));
//            } catch (NoSuchFieldException | IllegalAccessException e) {
//                continue;
//            }
//        }

        for(Field f : fields) {
            String fName = f.getName();
            System.out.println(fName);
            Method vehicleGetMethod = vehicleClass.getDeclaredMethod("get" + Character.toUpperCase(fName.charAt(0)) + fName.substring(1));
            vehicleGetMethod.setAccessible(true);
            try {
                Method carSetMethod = carClass.getDeclaredMethod("set" + Character.toUpperCase(fName.charAt(0)) + fName.substring(1), f.getType());
                carSetMethod.setAccessible(true);
                carSetMethod.invoke(car, vehicleGetMethod.invoke(vehicle));
            } catch(Exception ex) {
                continue;
            }

        }
        System.out.println(vehicle);
        System.out.println(car);


        Constructor c = vehicleClass.getDeclaredConstructors()[0];
        Object obj = c.newInstance("coco", "yellow", 3);
        System.out.println(obj);


    }

}
