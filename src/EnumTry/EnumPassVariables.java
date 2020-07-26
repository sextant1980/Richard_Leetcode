package EnumTry;

public class EnumPassVariables {
    public static void main(String[] args) {
        System.out.println(Type.Triangle);
        System.out.println(Type.Triangle.ordinal());
        System.out.println(Type.Triangle.getAnimal());
        System.out.println(Type.Hexgon.getNum());

        int bigOrSmall = Type.Rectangle.compareTo(Type.Hexgon);
        System.out.println(bigOrSmall);


    }
}

enum Type {
    Triangle("cat", 9), Rectangle("dog", 8), Hexgon("snake",5);

    private String animal;
    private int num;

    Type (String animal, int num) {
        this.animal = animal;
        this.num = num;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}