package com.functionalInter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class tmp {
    public static void main(String[] args){

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("bilao", 15, "female", 180));
        studentList.add(new Student("hobao", 12, "male", 190));
        studentList.add(new Student("diabi", 14, "female", 160));
        studentList.add(new Student("todao", 14, "male", 170));

        studentList = studentList.stream().sorted((a, b) -> a.getAge() - b.getAge() != 0? a.getAge() - b.getAge() : a.getName().compareTo(b.getName())).collect(Collectors.toList());

        Iterator it = studentList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
//        System.out.println(studentList);
//        I1 i1 = () -> stu.printNumber();
////        I1 i1 = stu::printNumber;
//        i1.m1();

//        List<Student> mylist = new ArrayList<>();
//        mylist.add(new Student("he1", 12, "male"));
//        mylist.add(new Student("guda", 13, "male"));
//        mylist.add(new Student("uda", 11, "female"));
//        mylist.add(new Student("tada", 12, "female"));
//        mylist.add(new Student("londa", 10, "male"));
//
//        List mylist2 = mylist.stream().filter(s -> {return s.getAge() > 11;}).
//                map(s -> {
//                    String name = s.getName();
//                    s.setName(name + "X");
//                    return s;
//                }).collect(Collectors.toList());
//
//        mylist2.forEach(s -> System.out.println(s));
    }
}
