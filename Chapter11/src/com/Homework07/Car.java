package com.Homework07;

public class Car {
    private float temperature;

    private class Air {
        public void flow() {
            if (temperature > 40) {
                System.out.println("Cool");
            } else if (temperature < 0) {
                System.out.println("Warm");
            } else {
                System.out.println("Shut down");
            }
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.temperature = 50;
        car.new Air().flow();
        car.temperature = -10;
        car.new Air().flow();
        car.temperature = 10;
        car.new Air().flow();
    }
}
