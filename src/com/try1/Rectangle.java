package com.try1;

import com.try1.Shape;

public class Rectangle implements Shape {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void try_out(){
        Square square = new Square(3.5);
        System.out.println(square.aa);
    }

    @Override
    public double area() {
        return width * length;
    }

    @Override
    public int compareTo(Shape o) {
        return this.area() > o.area()? 1 : (this.area() == o.area()? 0 : -1);
    }
}
