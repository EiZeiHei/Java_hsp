package com.Static;

public class StaticDetail {
    private static int num;

    public static void addNum() {
        num++;
        System.out.println("Num: " + num);
    }

    public static void main(String[] args) {
        int times = 10;
        for (int i = 0; i < times; i++) {
            addNum();
        }
    }
}