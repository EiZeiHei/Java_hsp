package com.InnerClass;

public class Anonymous {
    private final int num = 10;

    public void method() {
        new Abstract() {
            @Override
            public void say() {
                System.out.println("Anonymous say");
                System.out.println("num: " + num);
            }
        }.say();
    }

    public static void main(String[] args) {
        new Anonymous().method();
    }
}
