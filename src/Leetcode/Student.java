package Leetcode;

public class Student implements Comparable<Student>{
    private int age;
    private int score;

    public Student(int age, int score) {
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student stu) {
        Integer age1 = this.getAge();
        Integer age2 = stu.getAge();
        Integer score1 = this.getScore();
        Integer score2 = stu.getScore();

        int com_age = age1.compareTo(age2);
        int com_score = score1.compareTo(score2);
        return com_age != 0? com_age : com_score;
    }

    public static void main(String[] args) {
        Student stu1 = new Student(18, 97);
        Student stu2 = new Student(18, 98);

        System.out.println(stu1.compareTo(stu2));
    }
};


