package com.antra;

public class questions {
    public static void main(String[] args) {
        String a = "dksldkfj";

    }
}

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int Comparator(Person person){
        return this.age != person.age? this.age - person.age : this.firstName.compareTo(person.firstName);
    }
}
