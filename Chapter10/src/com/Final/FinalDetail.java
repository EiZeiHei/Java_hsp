package com.Final;

public class FinalDetail {
    private double radius;
    private final double PI;

    {
        PI = 3.14;
    }

    public FinalDetail(double radius) {
        this.radius = radius;
    }

    public double calArea() {
        return PI * radius * radius;
    }

    public static void main(String[] args) {
        System.out.println(new FinalDetail(1.1).calArea());
    }
}
