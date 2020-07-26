import java.util.Arrays;

public class Assignment01_14 {

    public static void main(String[] args){
        int[] a = new int[]{3, 8, 6, 5, 7};
        int[] b = new int[]{4, 3, 1, 2, 9};

        int[] c = new int[a.length + b.length];
        int i = 0;
        for(int x : a){
            c[i++] = x;
        }

        for(int x : b){
            c[i++] = x;
        }

        System.out.println("merged array is: " + Arrays.toString(c));

    }
}
