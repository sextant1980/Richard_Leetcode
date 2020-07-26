package EnumTry;

public class EnumSwitchPrac {
    public static void main(String[] args) {
//        Color myColor = Color.BLUE;
////        switch (myColor) {
////            case RED:
////                System.out.println("color is red");
////                break;
////            case BLUE:
////                System.out.println("color is blue");
////                break;
////            case YELLOW:
////                System.out.println("color is yellow");
////                break;
////            default:
////                System.out.println("color could be green");
////        }
        System.out.println(Color.BLUE.compareTo(Color.GREEN));
        System.out.println(Color.BLUE.ordinal());
    }
}

enum Color {
    RED("hell yeah", 39), BLUE("good", 21), YELLOW("jiehao", 12), GREEN("zhidao", 98);

    private String str;
    private int num;
    Color(String str, int num) {
        this.str = str;
        this.num = num;
    }
}
