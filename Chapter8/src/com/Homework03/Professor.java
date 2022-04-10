package com.Homework03;

public class Professor extends Teacher {
    private double level = 1.3;

    public Professor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("Additional Information: Professor & Level 1.3");
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }
}
