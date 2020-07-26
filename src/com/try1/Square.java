package com.try1;

public class Square implements Shape {
    private double length;
    int aa = 0;

    public Square(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public static void try_add_to(){
        Square square = new Square(3.5);
        square.add_to(5, 6);
        System.out.println(square.length);
    }

    public int add_to(int a, int b){
        return a + b;
    }

    @Override
    public double area() {
        return length * length;
    }

    @Override
    public int compareTo(Shape o) {
        return this.area() > o.area()? 1 : (this.area() == o.area()? 0 : -1);
    }
}
