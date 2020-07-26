public class Animal {

    private String name;
    private String color;

    public Animal(String name, String color){
        this.name = name;
        this.color = color;
    }

    public void eat(){
        System.out.println("animal eating");
    }

    public void walk(){
        System.out.println("animal walking");
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

//    abstract String try_out();
}
