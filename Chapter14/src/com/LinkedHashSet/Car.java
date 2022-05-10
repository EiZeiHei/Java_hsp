package com.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Objects;

public class Car {
    private final String name;
    private final int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();

        linkedHashSet.add(new Car("奥拓", 1000));
        linkedHashSet.add(new Car("奥迪", 300000));
        linkedHashSet.add(new Car("法拉利", 10000000));
        linkedHashSet.add(new Car("奥迪", 300000));
        linkedHashSet.add(new Car("保时捷", 70000000));
        linkedHashSet.add(new Car("奥迪", 300000));

        System.out.println(linkedHashSet);
    }
}
