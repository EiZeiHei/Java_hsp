package com.Homework03;

public class VicePro extends Teacher {
    private double level = 1.2;

    public VicePro(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("Additional Information: Vice Professor & Level 1.2");
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }
}
