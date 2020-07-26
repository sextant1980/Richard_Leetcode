package InterviewCode;

import java.util.Scanner;

public class EquifaxException {
    public static void main(String[] args) {
        EquifaxException ee = new EquifaxException();
        String enryptedName = ee.getEncryptedName("haHagoGo");
        System.out.println(enryptedName);
    }


    public String getEncryptedName(String name) {
        Validator vd = new Validator();
        boolean flag = vd.validate(name);
        if(flag) {
            StringBuilder sb = new StringBuilder(name.toLowerCase());
            sb = sb.reverse();
            return sb.toString();
        } else {
            throw new IllegalArgumentException("Try again with valid name");
        }
    }
}

class Validator {
    public boolean validate(String name) {
        if(name.compareTo("haHagoGo") == 0) {
            return true;
        }
        return false;
    }
}