package instanceBlock;

public class MyStudent {
    private String name;
    private int age;

    {
        System.out.println("in instance block");
        makeSound();
        System.out.println("end instance block");
    }

    public void makeSound(){
        System.out.println("in method");
    }

    public static void main(String[] args) {
        MyStudent myStudent = new MyStudent();
    }
}
