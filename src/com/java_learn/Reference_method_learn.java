package com.java_learn;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Reference_method_learn {
    public static void main(String[] args) {

        // ---------- Example 01: System.out :: println --------------
        ArrayList<Integer> al = new ArrayList<>();
        al.add(5);
        al.add(3);
        al.add(8);

        // ---------------------------------------------
        System.out.println("this is the original format for List.forEach(). Note that Consumer is a functional interface.");
        Consumer<Integer> con = new Consumer<Integer>() {
            @Override
            public void accept(Integer a) {
                System.out.println(a);
            }
        };
        al.forEach(con);

        //---------------------------------------------------
        System.out.println("this is the lambda format for List.forEach()");
        Consumer<Integer> con2 = a -> System.out.println(a);
        al.forEach(con2);

        // The above two lines can be merged together:
        System.out.println("forEach with merged lambda function:");
        al.forEach(a -> System.out.println(a));

        // Replace lambda function with method reference:
        System.out.println("Replace lambda function with method reference:");
        al.forEach(System.out :: println);

        // ---------- Example 02: Math :: pow --------------
        // original use of BiFunction
        BiFunction<Integer, Integer, Double> fun1 = new BiFunction<Integer, Integer, Double>() {
            @Override
            public Double apply(Integer a, Integer b) {
                return Math.pow(a, b);
            }
        };
        double result = fun1.apply(2, 4);
        System.out.println("Original use of BiFunction with Math.pow: result is " + result);

        // use Lambda function for BiFunction
        BiFunction<Integer, Integer, Double> fun2 = (a, b) -> Math.pow(a, b);
        double result2 = fun2.apply(2, 4);
        System.out.println("Use Lambda expression with Math.pow: result is " + result2);

        BiFunction<Integer, Integer, Double> fun3 = Math :: pow;
        double result3 = fun3.apply(2, 4);
        System.out.println("Replace Lambda expression with method reference: result is " + result3);

        // ---------- Example 03: .mapToInt --------------
        List<String> myList = Arrays.asList("18", "10", "36");
        myList.stream().mapToInt(Integer :: parseInt).forEach(System.out :: println);

        // ---------- Example 04: .mapToInt ---------------
        List<String> myList1 = Arrays.asList("18", "10", "36");
        double avgVal1 = myList1.stream().mapToInt(Integer::parseInt).average().orElse(0.0);
        System.out.println("the average value of myList1 is: " + avgVal1);

        List<Integer> myList2 = Arrays.asList(18, 10, 36);
        int avgVal2 = (int) myList2.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("the average value of myList2 is: " + avgVal2);
    }
}
