package EnumTry;

public class EnumSwitch {
    public static void main(String[] args) {
        Size s = Size.Something;
        switch (s) {
            case Small:
                System.out.println("size is small.");
                break;
            case Medium:
                System.out.println("size is medium.");
                break;
            case Large:
                System.out.println("size is large.");
                break;
            default:
                System.out.println("no matches!");
        }
    }
}

enum Size {
    Small, Medium, Large, Something;
}