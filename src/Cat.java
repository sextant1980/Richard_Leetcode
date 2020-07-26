public class Cat extends Animal{

    public Cat(String name, String color) {
        super(name, color);
    }

    public void scratching(){
        System.out.println("cat scratching");
    }

//    @Override
//    public int compareTo(Cat o) {
//        if(this.getName().compareTo(o.getName()) > 0){
//            return 1;
//        } else {
//            return -1;
//        }
//    }
}
