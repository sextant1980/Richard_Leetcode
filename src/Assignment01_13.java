import java.util.Scanner;

public class Assignment01_13 {

    public static void main(String[] args){
        myLogic();
    }

    public static void myLogic(){
        System.out.println("Please input something:");
        Scanner kb = new Scanner(System.in);
        if(kb.hasNextInt()){
            int x = kb.nextInt();
            if(x > 0){
                for(int i=0; i<x; i++){
                    doSomething(x);
                }
                myLogic();
            } else {
                System.out.println("Error: x is smaller or equal to 0!");
                myLogic();
            }
        } else {
            String tmp = kb.next();
            char tmpC = tmp.charAt(0);
            if(tmpC == 'q'){
                System.out.println("Program quitting......");
                return;
            } else {
                System.out.println("No such option. Please re-input again.");
                myLogic();
            }
        }

    }

    public static void doSomething(int x){

        int sumTmp = 0;
        for(int i=1; i<=x; i++){
            sumTmp = sumTmp + i;
        }
        System.out.println("Sum result is: " + sumTmp);
    }
}
