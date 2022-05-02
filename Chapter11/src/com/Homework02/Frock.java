package com.Homework02;

public class Frock {
    private static int currentNum = 100000;
    private final int serialNumber;

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public Frock() {
        this.serialNumber = this.getNextNum();
    }

    @Override
    public String toString() {
        return "Frock{" +
                "serialNumber=" + serialNumber +
                '}';
    }
}
