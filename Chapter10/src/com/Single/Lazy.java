package com.Single;

public class Lazy {
    private String name;

    private Lazy(String name) {
        System.out.println("constructor");
        this.name = name;
    }

    private static Lazy gf;

    public static Lazy getInstance() {
        if (gf == null) {
            gf = new Lazy("Lazy");
        }
        return gf;
    }

    @Override
    public String toString() {
        return "Lazy{" +
                "name='" + name + '\'' +
                '}';
    }
}
