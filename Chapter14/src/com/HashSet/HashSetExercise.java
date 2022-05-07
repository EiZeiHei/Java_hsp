package com.HashSet;

import java.util.HashSet;

public class HashSetExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        hashSet.add(new Employee("LA", 3000, new MyDate(1999, 12, 23)));
        hashSet.add(new Employee("LA", 30000, new MyDate(1999, 12, 23)));
        hashSet.add(new Employee("JJ", 3000, new MyDate(1999, 12, 23)));
        hashSet.add(new Employee("LA", 3000, new MyDate(2000, 3, 1)));

        System.out.println(hashSet);
    }
}
