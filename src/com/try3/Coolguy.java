package com.try3;

public class Coolguy {
    public static void main(String[] args) {
        Dude dude = new Dude();
        System.out.println(dude);

        dude.setAge(38);
        dude.setName("haoy");
        System.out.println(dude);
    }
}

class Dude {
    private String name;
    private int age;

    public Dude() {
    }

    @Override
    public String toString() {
        return "Dude{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
}
