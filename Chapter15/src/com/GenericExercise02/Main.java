package com.GenericExercise02;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Employee a = new Employee("A", 100000, new MyDate(12, 23, 1999));
        Employee b = new Employee("B", 1000, new MyDate(2, 13, 1998));
        Employee c = new Employee("A", 10000, new MyDate(3, 1, 2000));

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(a);
        employees.add(b);
        employees.add(c);

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                if (!a.getName().equals(b.getName())) {
                    return a.getName().compareTo(b.getName());
                } else if (a.getBirthday().getYear() != b.getBirthday().getYear()) {
                    return a.getBirthday().getYear() - b.getBirthday().getYear();
                } else if (a.getBirthday().getMonth() != b.getBirthday().getMonth()) {
                    return a.getBirthday().getMonth() - b.getBirthday().getMonth();
                } else {
                    return a.getBirthday().getDay() - b.getBirthday().getDay();
                }
            }
        });

        System.out.println(employees);
    }
}
