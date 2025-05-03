package org.example.dip;

public class Main {
    public static void main(String[] args) {

        DieselEngine engine = new DieselEngine("V8", 500, 50);
        DieselEngine dieselEngine = new DieselEngine("V8", 500, 100);
        PetrolEngine petrolEngine = new PetrolEngine("V6", 400, 60);
        Car car = new Car();
        car.setDieselEngine(engine);
        Car car2 = new Car();
        car.start();
        car2.start();
    }
}
