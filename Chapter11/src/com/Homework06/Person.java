package com.Homework06;

public class Person {
    private final String name;
    private Vehicles vehicles;

    public Person(String name) {
        this.name = name;
    }

    public void passOthers() {
        if (!(this.vehicles instanceof Horse)) {
            this.vehicles = Plant.getHorse();
            System.out.println(this.name + "骑白龙马闯天下");
        }
        Plant.getHorse().work();
    }

    public void passRiver() {
        if (!(this.vehicles instanceof Boat)) {
            this.vehicles = Plant.getBoat();
            System.out.println(this.name + "坐船过河");
        }
        Plant.getBoat().work();
    }

    public static void main(String[] args) {
        Person tsz = new Person("唐僧");

        tsz.passOthers();
        tsz.passRiver();
    }
}
