package com.Homework01;

public class Homework01 {
    public static String reverse(String str, int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < start; i++) {
            stringBuilder.append(str.charAt(i));
        }

        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = start; i < end + 1; i++) {
            stringBuilder1.append(str.charAt(i));
        }
        stringBuilder1.reverse();

        stringBuilder.append(stringBuilder1);

        for (int i = end + 1; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        @SuppressWarnings("all")
        String str = "abcdef";

        str = Homework01.reverse(str, 1, 4);

        System.out.println(str);
    }
}
