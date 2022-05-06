package com.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionExercise {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Dog("A", 1));
        list.add(new Dog("B", 10));
        list.add(new Dog("C", 100));

        // Enhanced for
        System.out.println("使用增强for");
        for (Object dog : list) {
            System.out.println(dog);
        }

        // Iterator
        System.out.println("使用Iterator");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object dog = iterator.next();
            System.out.println(dog);
        }
    }
}
