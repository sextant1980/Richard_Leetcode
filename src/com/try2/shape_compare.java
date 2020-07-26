package com.try2;

import com.try1.Circle;
import com.try1.Rectangle;
import com.try1.Square;

public class shape_compare {

    public static void main(String[] args) {
        Circle circle = new Circle(1.5);
        Rectangle rectangle = new Rectangle(5.0, 2.0);
        Square square = new Square(3);

        System.out.println(square.getLength());

        System.out.println("circle compare to rectangle, result is: " + circle.compareTo(rectangle));
        System.out.println("square compare to square, result is: " + square.compareTo(square));
        System.out.println("rectangle compare to square, result is: " + rectangle.compareTo(square));
    }
}
