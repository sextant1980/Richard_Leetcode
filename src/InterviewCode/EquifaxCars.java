package InterviewCode;

public class EquifaxCars {
    public static void main(String[] args) {
        int carType = 2;
        int carMileage = 3680;
        if(carType == 0) {
            Car wagonR = new WagonR(carMileage);
            wagonR.printCar("WagonR");
            System.out.println(wagonR.getIsSeden());
            System.out.println(wagonR.getSeats());
            System.out.println(wagonR.getMileage());
        }

        if(carType == 1) {
            Car hondaCity = new HondaCity(carMileage);
            hondaCity.printCar("HondaCity");
            System.out.println(hondaCity.getIsSeden());
            System.out.println(hondaCity.getSeats());
            System.out.println(hondaCity.getMileage());
        }

        if(carType == 2) {
            Car innovaCrysta = new InnovaCrysta(carMileage);
            innovaCrysta.printCar("InnovaCrysta");
            System.out.println(innovaCrysta.getIsSeden());
            System.out.println(innovaCrysta.getSeats());
            System.out.println(innovaCrysta.getMileage());
        }
    }
}

class InnovaCrysta extends Car {
    private int mileage;

    public InnovaCrysta(int mileage) {
        this.mileage = mileage;
    }
    @Override
    public String getSeats() {
        return String.valueOf(6);
    }

    @Override
    public boolean getIsSeden() {
        return false;
    }

    @Override
    String getMileage() {
        return String.valueOf(mileage);
    }
}


class HondaCity extends Car {
    private int mileage;

    public HondaCity(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String getSeats() {
        return String.valueOf(4);
    }

    @Override
    public boolean getIsSeden() {
        return true;
    }

    @Override
    String getMileage() {
        return String.valueOf(mileage);
    }
}

class WagonR extends Car {
    private int mileage;

    public WagonR(int mileage) {
//        super(isSeden, seats);
        this.mileage = mileage;
    }

    @Override
    public String getSeats() {
        return String.valueOf(4);
    }

    @Override
    public boolean getIsSeden() {
        return false;
    }

    @Override
    String getMileage() {
        return String.valueOf(mileage);
    }
}

abstract class Car {
    private boolean isSeden;
    private String seats;

    public Car() {
    }

    public boolean getIsSeden() {
        return isSeden;
    }

    public String getSeats() {
        return seats;
    }

    public void printCar(String name) {
        System.out.println(name);
    }

    abstract String getMileage();
}