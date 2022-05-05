package com.Homework04;

import java.util.Scanner;

public class Homework04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input string:");
        String str = scanner.next();
        char[] chars = str.toCharArray();

        int numOfUpper = 0;
        int numOfLower = 0;
        int numOfNum = 0;

        for (char aChar : chars) {
            if (aChar >= 'A' && aChar <= 'Z') {
                numOfUpper++;
            }
            if (aChar >= 'a' && aChar <= 'z') {
                numOfLower++;
            }
            if (aChar >= '0' && aChar <= '9') {
                numOfNum++;
            }
        }

        System.out.println("numOfUpper:\t" + numOfUpper + "\nnumOfLower:\t" + numOfLower + "\nnumOfNum:\t" + numOfNum);
    }
}
