package reflectionPrac;

import java.util.Objects;

public class Vehicle {
    private String name;
    private String color;
    private int height;

//    static Vehicle vehicle;
//
//    static {
//        vehicle = new Vehicle("dida", "blue", 2);
//        System.out.println("static block called");
//    }

    public Vehicle(String name, String color, int height) {
        this.name = name;
        this.color = color;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", height=" + height +
                '}';
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(this == obj) return true;
//        if(obj == null || obj.getClass() != this.getClass()) return false;
//        Vehicle vehicle = (Vehicle) obj;
//        if(vehicle.getName().equals(name) && vehicle.getColor().equals(color) && vehicle.getHeight() == height) return true;
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, color, height);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return height == vehicle.height &&
                Objects.equals(name, vehicle.name) &&
                Objects.equals(color, vehicle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, height);
    }
}
