package com.Homework04;

public class Employee {
    private String name;
    private double salPerDay;
    private int days;

    private double sal;

    public Employee(String name, double salPerDay, int days) {
        this.name = name;
        this.salPerDay = salPerDay;
        this.days = days;
    }

    public void printSal() {
        System.out.println("Employee's salary is " + sal);
    }

    public double getSal() {
        sal = salPerDay * days;
        return sal;
    }
}
