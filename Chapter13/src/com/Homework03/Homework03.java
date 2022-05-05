package com.Homework03;

import java.util.Scanner;

public class Homework03 {
    public static String reName(String name) {
        String[] names = name.split(" ");
        name = names[2] + ", " + names[0] + " ." + names[1].charAt(0);
        return name;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input name:");
        String name = scanner.nextLine();
        System.out.println(Homework03.reName(name));
    }
}
