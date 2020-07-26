package com.try1;

import com.try1.Shape;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 2 * this.radius * this.radius;
    }

    @Override
    public int compareTo(Shape o) {
        return this.area() > o.area()? 1 : (this.area() == o.area()? 0 : -1);
    }
}
