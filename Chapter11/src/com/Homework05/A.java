package com.Homework05;

public class A {
    private class B {
        @SuppressWarnings(value = "all")
        private final String name = "BB";

        public void show() {
            System.out.println(name + "\n" + A.this.name);
        }
    }

    private final String name = "AA";

    public static void main(String[] args) {
        A a = new A();
        a.new B().show();
    }
}
