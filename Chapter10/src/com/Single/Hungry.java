package com.Single;

public class Hungry {
    private String name;

    private Hungry(String name) {
        System.out.println("constructor");
        this.name = name;
    }

    private static Hungry gf = new Hungry("Hungry");

    public static Hungry getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "Hungry{" +
                "name='" + name + '\'' +
                '}';
    }
}
