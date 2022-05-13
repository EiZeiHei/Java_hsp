package com.Homework02;

import java.util.ArrayList;
import java.util.Iterator;

public class Car {
    private final String name;
    private final int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
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
        Car car = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);

        ArrayList arrayList = new ArrayList();
        arrayList.add(car);
        arrayList.add(car2);

        System.out.println("增强for");
        for (Object o : arrayList) {
            System.out.println(o);
        }

        System.out.println("迭代器");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        System.out.println("add\t" + arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(car);
        arrayList2.add(car2);
        arrayList.remove(car);
        System.out.println("remove\t" + arrayList);
        System.out.println("contains\t" + arrayList.contains(car2));
        System.out.println("size\t" + arrayList.size());
        System.out.println("isEmpty\t" + arrayList.isEmpty());
        arrayList.clear();
        System.out.println("clear\t" + arrayList);
        arrayList.addAll(arrayList2);
        System.out.println("addAll\t" + arrayList);
        System.out.println("containsAll\t" + arrayList.containsAll(arrayList2));
        arrayList.removeAll(arrayList2);
        System.out.println("removeAll\t" + arrayList);
    }
}
