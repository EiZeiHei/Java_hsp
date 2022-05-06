package com.Collection;

public record Dog(String name, int age) {

    @Override
    public String toString() {
        return "Dog " + name + "\t" + "age: " + age;
    }
}
