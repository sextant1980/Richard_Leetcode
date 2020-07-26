package com.functionalInter;

public class Student {
    private String name;
    private int age;
    private int score;
    private String gender;
    public String coolname;

    public Student(String name, int age, String gender, int score) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.score = score;
    }

    public void tryMethod(){
        System.out.println(name);
        System.out.println(coolname);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void printNumber(){
        for(int i = 0; i < 10; i++){
            System.out.println("the number is: " + i);
        }
    }
}
