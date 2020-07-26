package CoreJavaOtherKnowledge;

public class PreincrementVsPostincrement {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a++ + a++); // equivalent to b = a; a = a + 1; c = a; a = a + 1; sout(b + c); so a = 3, result is 3
        System.out.println(a); // a = 3
        System.out.println(a++); // equivalent to sout(a); a = a + 1; so a = 4;
        System.out.println(a);  // a = 4

        a = 1;
        System.out.println(++a + ++a); // equivalent to a = a + 1; b = a; a = a + 1; c = a; sout(b + c); so a = 3, result is 5

        a = 1;
        System.out.println(++a + a++); // result is 4, a = 3

        a = 1;
        System.out.println(a++ + ++a); // result is 4, a = 3

        String c = "hudong";
        int d=10,e=20,f=30;
        System.out.println(c + d + e + f);
        System.out.println(d + e + f + c);

    }
}
