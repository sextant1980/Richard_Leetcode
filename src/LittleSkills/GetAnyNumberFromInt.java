package LittleSkills;

public class GetAnyNumberFromInt {
    public static void main(String[] args) {
        int aa = 5687326;

        // 取个位数
        // method 1:
        System.out.println(aa % 10);

        // method 2:
        int n = String.valueOf(aa).length();
        int result = Character.getNumericValue(String.valueOf(aa).charAt(n - 1));
//        System.out.println(result);

        // 取十位数
        // method 1:
        System.out.println((aa / 10) % 10 );

        // method 2:
        int n2 = String.valueOf(aa).length();
        int result2 = Character.getNumericValue(String.valueOf(aa).charAt(n - 2));
//        System.out.println(result2);

        // 取百位数
        System.out.println((aa / 100) % 10);

        int n3 = String.valueOf(aa).length();
        int result3 = Character.getNumericValue(String.valueOf(aa).charAt(n - 3));
        System.out.println(result3);

        //取最后两位
        System.out.println(aa % 100);

        int n4 = String.valueOf(aa).length();
        int result4 = Integer.parseInt(String.valueOf(aa).substring(n-2));
        System.out.println(result4);

        //取前两位
        // method 1
        int n5 = String.valueOf(aa).length();
        System.out.println(aa / ((int) Math.pow(10, n5-2)));

        // method 2
        System.out.println(Integer.parseInt(String.valueOf(aa).substring(0, 2)));

        //取前四位
        // method 1
        int n6 = String.valueOf(aa).length();
        System.out.println(aa / ((int) Math.pow(10, n6-4)));

        // method 2
        System.out.println(Integer.parseInt(String.valueOf(aa).substring(0, 4)));
    }
}
