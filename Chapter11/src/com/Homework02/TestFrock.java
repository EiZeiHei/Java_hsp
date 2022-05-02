package com.Homework02;

public class TestFrock {
    public static void main(String[] args) {
        System.out.println("Number1: " + Frock.getNextNum());
        System.out.println("Number2: " + Frock.getNextNum());

        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();
        System.out.println(frock1);
        System.out.println(frock2);
        System.out.println(frock3);
    }
}