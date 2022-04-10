package com.Homework03;

public class Lecturer extends Teacher {
    private double level = 1.1;

    public Lecturer(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("Additional Information: Lecturer & Level 1.1");
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }
}
