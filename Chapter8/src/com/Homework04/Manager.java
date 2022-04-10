package com.Homework04;

public class Manager extends Employee {
    private double sal;

    public Manager(String name, double salPerDay, int days) {
        super(name, salPerDay, days);
    }

    @Override
    public void printSal() {
        sal = 1000 + super.getSal() * 1.2;
        System.out.println("Employee's salary is " + sal);
    }
}
