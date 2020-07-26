package CoreJavaOtherKnowledge;

public class AutoPromote {
    public static void main(String[] args) {
        byte a1 = 127;
        byte b1 = 1;
        System.out.println((byte) (a1 + b1));
        System.out.println(a1 + b1); // auto-promoted to short

        short a2 = 32767;
        short b2 = 1;
        System.out.println((short) (a2 + 1));
        System.out.println(a2 + 1); // auto-promoted to int

        int a3 = 2147483647;
        int b3 = 1;
        System.out.println((long) a3 + b3);
        System.out.println(a3 + b3); // note that this is different from a1 + b1 and a2 + b2, a3 + b3 is not auto promoted.

    }
}
