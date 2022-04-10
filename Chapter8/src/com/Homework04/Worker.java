package com.Homework04;

public class Worker extends Employee {
    private double sal;

    public Worker(String name, double salPerDay, int days) {
        super(name, salPerDay, days);
    }

    @Override
    public void printSal() {
        sal = super.getSal() * 1.0;
        System.out.println("Employee's salary is " + sal);
    }
}
