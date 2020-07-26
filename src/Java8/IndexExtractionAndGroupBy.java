package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IndexExtractionAndGroupBy {
    static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1,"James", 25, 3600));
        customerList.add(new Customer(2,"Ada", 23, 1800));
        customerList.add(new Customer(3,"Grace", 35, 5600));
        customerList.add(new Customer(4,"Bob", 28, 2800));
        customerList.add(new Customer(5,"Cindy", 20, 8800));
        customerList.add(new Customer(6,"Ryan", 40, 16000));
        customerList.add(new Customer(7,"Alan", 44, 6400));
    }

    public static void main(String[] args) {
        // problem 1: extract index of customers with name start with A or a
        List<Integer> customerIndex = IntStream.range(0, customerList.size()).filter(i -> customerList.get(i).getName().charAt(0) == 'A' || customerList.get(i).getName().charAt(0) == 'a').boxed().collect(Collectors.toList());
//        List<Integer> customerIndex = customerList.stream().filter(x -> x.getName().startsWith("A") || x.getName().startsWith("a")).mapToInt(x -> customerList.indexOf(x)).boxed().collect(Collectors.toList());
        System.out.println(customerIndex);

        // problem 2: group customers by age by section of 10 years
        Map<Object, List<Customer>> myMap = customerList.stream().collect(Collectors.groupingBy(x -> "in " + String.valueOf(x.getAge() / 10) + "0s"));
        System.out.println(myMap);

        // problem 3: grouping customers by age and summing/averaging
        Map<Object, Double> myMap2 = customerList.stream().collect(Collectors.groupingBy(x -> x.getAge() /10, Collectors.summingDouble(x -> x.getSalary())));
        System.out.println(myMap2);
    }
}

class Customer {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Customer(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString(){
        return "{id: " + id + "; name: " + name + "; age: " + age + "}";
    }
}
